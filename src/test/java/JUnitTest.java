import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mashape.unirest.request.GetRequest;
import junit.framework.*;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class JUnitTest {

    @Test
    public void TestGitHubAPI() throws UnirestException {
        Unirest.setTimeouts(0, 0);
        GetRequest request =
                Unirest.get("http://api.github.com/repos/testnakov/test-nakov-repo/issues");

        var response = request.asJson();
        Assert.assertEquals(200, response.getStatus());
        var json = response.getBody();
        var resultArray = json.getArray();
        var item0 = (JSONObject) resultArray.get(0);
        long id = item0.getLong("id");
        System.out.println(id);
        Assert.assertTrue(id > 0);
    }
}