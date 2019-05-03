/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.g3.common.serviceLoader;

import dk.sdu.g3.common.services.IUnitFactory;
import java.util.Collection;
import org.openide.util.Lookup;
import org.openide.util.LookupEvent;
import org.openide.util.LookupListener;

/**
 *
 * @author sebastian
 */
public class ServiceLoader {

//        private final Lookup lookup = Lookup.getDefault();
//        private Lookup.Result<IUnitFactory> result;
//
//        public ServiceLoader() {
//            //vars
//            
//            result = lookup.lookupResult(IUnitFactory.class); //Finds SP'
//            result.addLookupListener(lookupListener);
//            result.allItems();
//
//            System.out.println("---IGamePluginService---");
//            //inizial load
//            for (IUnitFactory plugin : result.allInstances()) {
//                System.out.println(plugin);
////                UnitFactoryList.add(plugin);
//            }
//        }
//
//        private final LookupListener lookupListener = new LookupListener() {
//            @Override
//            public void resultChanged(LookupEvent le) {
//
//                Collection<? extends IUnitFactory> updated = result.allInstances();
//
//                for (IUnitFactory us : updated) {
//                    // Newly installed modules
//                    if (!UnitFactoryList.contains(us)) {
//                        UnitFactoryList.add(us);
//                    }
//                }
//
//                // Stop and remove module
//                for (IUnitFactory gs : UnitFactoryList) {
//                    if (!updated.contains(gs)) {
//                        
//                        UnitFactoryList.remove(gs);
//                    }
//                }
//            }
//        };
//
//        private <T> Collection<? extends T> getSP(Class<T> SPI) {
//            return lookup.lookupAll(SPI);
//        }
//
    }