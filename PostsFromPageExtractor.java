import facebook4j.Comment;
import facebook4j.Facebook;
import facebook4j.FacebookException;
import facebook4j.FacebookFactory;
import facebook4j.PagableList;
import facebook4j.Post;
import facebook4j.Reading;
import facebook4j.ResponseList;
import facebook4j.auth.AccessToken;

public class PostsFromPageExtractor {

/*

A simple Facebook4J client which
illustrates how to access group feeds / posts / comments.
@param args
@throws FacebookException 
*/
public static void main(String[] args) throws FacebookException {

 // Generate facebook instance.
Facebook facebook = new FacebookFactory().getInstance();
// Use default values for oauth app id.
facebook.setOAuthAppId("2341427892606173", "84b038eca8e283580d972c634029be67");
// Get an access token from: 
// https://developers.facebook.com/tools/explorer
// Copy and paste it below.
String accessTokenString = "EAAhRhCnOVN0BANgrn8wg9JlBhtDVORKfbAvbSpsDMi4CvdmN7pfeKhVB91qjSbZCwO2gDSLdGaYCw0O73RUhHZAqnSzxb3KE95QQzJlDJ0CqsKUdICcSdDKu0kK8uPl2ZCwSvXY5s6bhRouoLyxKPoCMktzq0XGGTs8n1mmmNngyieTUwD40ZAkmakpI0OrcAb9fZAah3zQZDZD";
AccessToken at = new AccessToken(accessTokenString);
// Set access token.
facebook.setOAuthAccessToken(at);

 // We're done.
// Access group feeds.
// You can get the group ID from:
// https://developers.facebook.com/tools/explorer

 // Set limit to 25 feeds.

 ResponseList<Post> feeds = facebook.getFeed("100002094753878",
new Reading().limit(25));

 // For all 25 feeds...
for (int i = 0; i < feeds.size(); i++) {
// Get post.
Post post = feeds.get(i);
// Get (string) message.
String message = post.getMessage();
// Print out the message.
System.out.println(message);
PagableList comments = post.getComments();
String date = post.getCreatedTime().toString();
// String name = post.getFrom().getName();
String id = post.getId();
System.out.println(date);
System.out.println(id);
}
 }	
}