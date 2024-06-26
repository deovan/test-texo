package org.texo.steps.web;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import org.json.JSONArray;
import org.json.JSONObject;
import org.texo.page.GuidesPage;

import static org.junit.jupiter.api.Assertions.*;
import static org.texo.steps.Hook.driver;

public class GuidesStepDefinitions extends GuidesPage {

    String jsonData;

    @Dado("que acesso a pagina {string}")
    public void queAcessoAPagina(String url) {
        driver.get(url);
    }

    @E("acesso o link {string} na página")
    public void acessoOLink(String linkName) {
        switch (linkName) {
            case "/albums/1/photos":
                clickOnAlbum1PhotosLink();
                break;
            default:
                fail("Menu não mapeado: " + linkName);
                break;
        }
    }

    @E("capturo os dados exibidos em tela")
    public void capturoOsDadosExibidosEmTela() {
        jsonData = getJsonDataAsString();
    }

    @Então("valido os dados do objeto com id {int}")
    public void validoOsDadosDoObjetoComId(int idPhoto) {
        JSONArray jsonArray = new JSONArray(jsonData);
        JSONObject objectWithId6 = null;
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            if (jsonObject.getInt("id") == idPhoto) {
                objectWithId6 = jsonObject;
                break;
            }
        }

        assertNotNull(objectWithId6, "Objeto com id " + idPhoto + " não encontrado");
        assertEquals("accusamus ea aliquid et amet sequi nemo", objectWithId6.getString("title"));
        assertEquals(1, objectWithId6.getInt("albumId"));
        assertEquals("https://via.placeholder.com/600/56a8c2", objectWithId6.getString("url"));
        assertEquals("https://via.placeholder.com/150/56a8c2", objectWithId6.getString("thumbnailUrl"));
    }
}
