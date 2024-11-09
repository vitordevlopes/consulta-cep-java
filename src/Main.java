import com.vitor.viacep.model.CepService;
import com.vitor.viacep.model.Menu;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {

        Menu menu = new Menu(new CepService());

        menu.showMenu();

    }

}
