package fr.defalt.simpleinvisibleblock;

import java.io.File;

public class ClientProxy extends CommonProxy{
    @Override
    public void preInit(File configFile)
    {
        super.preInit(configFile);
        System.out.println("pre init côté client");
    }

    @Override
    public void init()
    {
        super.init();
    }

}
