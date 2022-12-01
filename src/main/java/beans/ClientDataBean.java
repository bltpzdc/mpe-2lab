package beans;

import lombok.Getter;
import lombok.Setter;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named("clientData")
@SessionScoped
public class ClientDataBean implements Serializable {
    @Getter @Setter
    private String[] x = new String[7];
    @Getter @Setter
    private String y;
    @Getter @Setter
    private String radius;
    @Getter @Setter
    private String hiddenX;

    public String getInfo(){
        return y + " " + radius;
    }
}
