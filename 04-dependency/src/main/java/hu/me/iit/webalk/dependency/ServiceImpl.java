package hu.me.iit.webalk.dependency;

public class ServiceImpl implements Service {
    private final Dependency dependency;

    public ServiceImpl(Dependency dependency) {
        this.dependency = dependency;
    }

    @Override
    public void calculate() {
        dependency.helpNoParameterNoReturnValue();
    }


    public int return5() {
        return 5;
    }

    public int callHelpAndUseReturnValue() {
        return dependency.helpNoParameterReturnValue();
    }

    public void callHelpAndPassParameter5() {
         dependency.helpWithParameterNoReturnValue(5);
    }

}
