package org.texo.steps.api;

import io.cucumber.java.en.Given;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.json.JSONObject;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.texo.steps.Hook.*;

public class ApiStepDefinitions {

    @Given("ana example scenario")
    public void anExampleScenario() {
    }

    @Dado("que eu defina o path da url {string}")
    public void queEuDefinaAUrl(String url) {
        scenario.log("Path: " + url);
        request.basePath(url);
    }

    @E("defina o atributo {string} com o valor {string}")
    public void definaOAtributoComOValor(String name, String value) {
        request.queryParam(name, value);
        scenario.log("Query param: " + name + "=" + value);
    }

    @Quando("eu realizar uma requisição do tipo {string}")
    public void euRealizarUmaRequisiçãoDoTipoGET(String metodo) {
        scenario.log("Método: " + metodo);
        switch (metodo) {
            case "GET":
                lastResponse = request.get();
                break;
            case "POST":
                lastResponse = request.post();
                break;
            case "PUT":
                lastResponse = request.put();
                break;
            default:
                throw new IllegalArgumentException("Método não mapeado: " + metodo);
        }

        scenario.log("Response: " + lastResponse.getBody().asString());
    }

    @Então("o statuscode deve ser {int}")
    public void oStatuscodeDeveSer(int status) {
        scenario.log("Status code: " + status);
        lastResponse.then().log().all().statusCode(status);
    }

    @E("o email do objeto retornado deve ser {string}")
    public void oEmailDoObjetoRetornadoDeveSer(String email) {
        lastResponse.then().body("email[0]", equalTo(email));
    }

    @E("defina o body da requisição com o seguinte conteúdo:")
    public void definaOBodyDaRequisiçãoComOSeguinteConteúdo(String body) {
        scenario.log("Body: " + body);
        request.body(body);
    }

    @E("deve retonar o id do usuário criado")
    public void deveRetonarOIdDoUsuárioCriado() {
        lastResponse.then().body("id", notNullValue());
    }

    @E("deve retonar os dados do usuário editado")
    public void deveRetonarOsDadosDoUsuárioEditado(String expectedResponse) {
        JSONObject expectedJson = new JSONObject(expectedResponse);
        JSONObject responseBody = new JSONObject(lastResponse.getBody().asString());
        assertEquals(expectedJson.getString("email"), responseBody.getString("email"));
        assertEquals(expectedJson.getString("lat"), responseBody.getString("lat"));
        assertEquals(expectedJson.getString("lng"), responseBody.getString("lng"));

    }
}
