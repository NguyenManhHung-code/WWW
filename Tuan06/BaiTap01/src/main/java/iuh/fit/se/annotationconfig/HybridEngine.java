package iuh.fit.se.annotationconfig;

import org.springframework.stereotype.Component;

@Component("hybridEngine")
public class HybridEngine implements Engine {
    @Override
    public void start() {
        System.out.println("Hybrid Engine started...");
    }
}
