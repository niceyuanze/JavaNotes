package concurrency.threadpool;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class MapReduceTest {

    public static void main(String[] args) {
        String[] fc = {"hello world",
                "hello me",
                "hello fork",
                "hello join",
                "fork join in world"};
        //����ForkJoin�̳߳�
        ForkJoinPool fjp =
                new ForkJoinPool(3);
        //��������
        MR mr = new MR(
                fc, 0, fc.length);
        //��������
        Map<String, Long> result =
                fjp.invoke(mr);
        //������
        result.forEach((k, v) ->
                System.out.println(k + ":" + v));
    }

    //MRģ����
    static class MR extends
            RecursiveTask<Map<String, Long>> {
        private String[] fc;
        private int start, end;

        //���캯��
        MR(String[] fc, int fr, int to) {
            this.fc = fc;
            this.start = fr;
            this.end = to;
        }

        @Override
        protected Map<String, Long> compute() {
            if (end - start == 1) {
                return calc(fc[start]);
            } else {
                int mid = (start + end) / 2;
                MR mr1 = new MR(
                        fc, start, mid);
                mr1.fork();
                MR mr2 = new MR(
                        fc, mid, end);
                //���������񣬲����غϲ��Ľ��
                return merge(mr2.compute(),
                        mr1.join());
            }
        }

        //�ϲ����
        private Map<String, Long> merge(
                Map<String, Long> r1,
                Map<String, Long> r2) {
            Map<String, Long> result =
                    new HashMap<>();
            result.putAll(r1);
            //�ϲ����
            r2.forEach((k, v) -> {
                Long c = result.get(k);
                if (c != null)
                    result.put(k, c + v);
                else
                    result.put(k, v);
            });
            return result;
        }

        //ͳ�Ƶ�������
        private Map<String, Long> calc(String line) {
            Map<String, Long> result =
                    new HashMap<>();
            //�ָ��
            String[] words =
                    line.split("\\s+");
            //ͳ�Ƶ�������
            for (String w : words) {
                Long v = result.get(w);
                if (v != null)
                    result.put(w, v + 1);
                else
                    result.put(w, 1L);
            }
            return result;
        }
    }
}
