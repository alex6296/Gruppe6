/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.g3.common.serviceLoader;

import java.util.ArrayList;
import java.util.Collection;
import org.openide.util.Lookup;
import org.openide.util.LookupEvent;
import org.openide.util.LookupListener;

/**
 *
 * @author sebastian
 */
public class ServiceLoader {
        ArrayList<Class> ServiceProviderList = new ArrayList();
        Class ServiceProvider;
        Class IService;

        private final Lookup lookup = Lookup.getDefault();
        private Lookup.Result<Class> result;

        public ServiceLoader(Class ServiceProvider, Class IService) {
            //vars
            this.ServiceProvider = ServiceProvider;
            this.IService = IService;
            result = lookup.lookupResult(IService); //Finds SP'
            result.addLookupListener(lookupListener);
            result.allItems();

            System.out.println("---IGamePluginService---");
            //inizial load
            for (Class plugin : result.allInstances()) {
                System.out.println(plugin);
                ServiceProviderList.add(plugin);
            }
        }

        private final LookupListener lookupListener = new LookupListener() {
            @Override
            public void resultChanged(LookupEvent le) {

                Collection<? extends Class> updated = result.allInstances();

                for (Class us : updated) {
                    // Newly installed modules
                    if (!ServiceProviderList.contains(us)) {
                        ServiceProviderList.add(us);
                    }
                }

                // Stop and remove module
                for (Class gs : ServiceProviderList) {
                    if (!updated.contains(gs)) {
                        
                        ServiceProviderList.remove(gs);
                    }
                }
            }
        };

        private <T> Collection<? extends T> getSP(Class<T> SPI) {
            return lookup.lookupAll(SPI);
        }

    }