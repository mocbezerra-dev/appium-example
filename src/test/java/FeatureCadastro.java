import com.example.AppiumExample.AppiumDriverConfig;
import com.example.AppiumExample.pages.CadastroPageObject;
import com.example.AppiumExample.pages.LoginPageObject;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.junit.Test;

import java.net.MalformedURLException;

import static org.junit.Assert.assertTrue;

public class FeatureCadastro {
    @Test
    public void naoConsigoCadastrarUsuarioComSenhasQueNaoConferem() {
        AppiumDriver driver = AppiumDriverConfig.getInstance().driver;

        LoginPageObject loginPageObject = new LoginPageObject(driver);
        loginPageObject.buscarElementos();

        CadastroPageObject cadastroPageObject = loginPageObject.irParaTelaDeCadastro();
        cadastroPageObject.buscarElementos();

        cadastroPageObject.cadastrar("Mateus Oliveira", "abobora", "jaca");

        assertTrue(cadastroPageObject.getErrorMessage().contains("Senhas não conferem"));

        driver.navigate().back();
    }

    @Test
    public void cadastroUsuarioComSucesso() {
        AppiumDriver driver = AppiumDriverConfig.getInstance().driver;

        LoginPageObject loginPageObject = new LoginPageObject(driver);
        loginPageObject.buscarElementos();

        CadastroPageObject cadastroPageObject = loginPageObject.irParaTelaDeCadastro();
        cadastroPageObject.buscarElementos();

        cadastroPageObject.cadastrar("Mateus Oliveira", "abobora", "abobora");

        loginPageObject.buscarElementos();
    }
}
