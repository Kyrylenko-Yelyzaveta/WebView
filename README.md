# WebView
Single request application

## Main task
Develop android application using kotlin. App must
consist of two screens: a loading screen and a webview screen. For screens
you need to use fragments, not activity.
When launching the application, display the loading screen and make a get request
to the server:

`https://efs5i1ube5.execute-api.eu-central-1.amazonaws.com/prod`

Аfter receiving a response you need to stop the download and open the screen with
webview. In webview need to fire "link" link if it's the first one
app launch or open "home" link if webview with "link" already
launched before.

After completing the task, you need to build debug.apk and
release.apk or release.aab for android.
Note: the server sends json like this:
`{
"link":"https://www.google.com.ua/",
"home":"https://www.youtube.com/"
}
`

## Extra tasks

 - Add ability to go back in webview when clicked
buttons back.
 - Save the parameters sent by the server and use them when
subsequent launches.
 - Run the application in full-screen mode, hiding the system ui.
 - Set any application icon.

## Highlights

<table>
	<tr>
		<th width="50%">
			First launch<br>
		</th>
		<th width="50%">
			Second launch<br>
		</th>
	<tr><!-- Prevent zebra stripes --></tr>
	<tr>
		<td>
			<img src="https://github.com/Kyrylenko-Yelyzaveta/WebView/blob/main/FirstLaunch.gif"/>
		</td>
		<td>
			<img src="https://github.com/Kyrylenko-Yelyzaveta/WebView/blob/main/SecondLaunch.gif"/>
		</td>
	</tr>

</table>
