package com.example.AppiumExample.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CadastroPageObject extends PageObjectBase {

    private final By nomeID;
    private final By senhaID;
    private final By confirmarSenhaID;
    private final By cadastrarID;
    private final By erroID;

    private MobileElement nomeCampo;
    private MobileElement senhaCampo;
    private MobileElement confirmarSenhaCampo;
    private MobileElement cadastrarBotao;
    private MobileElement erroMensagem;


    public CadastroPageObject(AppiumDriver driver) {
        super(driver);
        nomeID = By.id("br.com.alura.aluraesporte:id/input_nome");
        senhaID = By.id("br.com.alura.aluraesporte:id/input_senha");
        confirmarSenhaID = By.id("br.com.alura.aluraesporte:id/input_confirmar_senha");
        cadastrarID = By.id("br.com.alura.aluraesporte:id/cadastro_usuario_botao_cadastrar");
        erroID = By.id("br.com.alura.aluraesporte:id/erro_cadastro");
    }

    @Override
    public void buscarElementos() {
        nomeCampo = (MobileElement) driver.findElement(nomeID);
        senhaCampo = (MobileElement) driver.findElement(senhaID);
        confirmarSenhaCampo = (MobileElement) driver.findElement(confirmarSenhaID);
        cadastrarBotao = (MobileElement) driver.findElement(cadastrarID);
    }

    public void cadastrar(String nome, String senha, String confirmarSenha) {
        nomeCampo.setValue(nome);
        senhaCampo.setValue(senha);
        confirmarSenhaCampo.setValue(confirmarSenha);

        cadastrarBotao.click();
    }

    public String getErrorMessage() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(erroID));

        erroMensagem = (MobileElement) driver.findElement(erroID);

        return erroMensagem.getText();
    }
}
