package blue.thejester.luminaire.core;

public class ClientOnlyProxy extends CommonProxy {

    @Override
    public void preInit() {
        super.preInit();
    }

    @Override
    public boolean isDedicatedServer() {
        return false;
    }

    @Override
    public void init() {
        super.init();
    }

    @Override
    public void postInit() {
        super.postInit();
    }

}
