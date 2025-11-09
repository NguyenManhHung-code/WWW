package iuh.fit.se.annotationconfig;

import org.springframework.stereotype.Component;

@Component("icEngine")
public class ICEngine implements Engine {
    @Override
    public void start() {
        System.out.println("Internal Combustion Engine started...");
    }
}
