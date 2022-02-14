package com.example.AppiumExample.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

public class LoginPageObject extends PageObjectBase {

    private final By usuarioID;
    private final By senhaID;
    private final By cadastroID;
    private MobileElement usuarioCampo;
    private MobileElement senhaCampo;
    private MobileElement cadastroBotao;

    public LoginPageObject(AppiumDriver driver) {
        super(driver);
        usuarioID = By.id("br.com.alura.aluraesporte:id/input_usuario");
        senhaID = By.id("br.com.alura.aluraesporte:id/input_senha");
        cadastroID = By.id("br.com.alura.aluraesporte:id/login_botao_cadastrar_usuario");
    }

    @Override
    public void buscarElementos() {
        usuarioCampo = (MobileElement) driver.findElement(usuarioID);
        senhaCampo = (MobileElement) driver.findElement(senhaID);
        cadastroBotao = (MobileElement) driver.findElement(cadastroID);
    }

    public CadastroPageObject irParaTelaDeCadastro() {
        cadastroBotao.click();

        return new CadastroPageObject(this.driver);
    }
}
