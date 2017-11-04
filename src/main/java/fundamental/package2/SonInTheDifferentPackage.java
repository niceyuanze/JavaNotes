package fundamental.package2;

import fundamental.package1.Father;

public class SonInTheDifferentPackage extends Father{
    @Override
    protected void methodProtected() {
        super.methodProtected();
    }
}
