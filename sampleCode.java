private void saveData(byte[] data){
	ParseFile file = new ParseFile("talk_on_parse.mp3", data);
	file.saveInBackground();

	ParseObject sessionObject = new ParseObject("session");
	sessionObject.put("category", crisptalk);
	sessionObject.pus("soundfile", file);
	sessionObject.saveInBackground();
}

ParseFile droidcon_mp3 = (ParseFile) sessionObject.get("soundfile");
droidcon_mp3.getDataInBackground(new GetDataCallback(){
	public void done(byte[] data, ParseException e){
		if(e == null){
			//data has the bytes for mp3
		} else {
			// something went wrong
		}
	}
});


ParseObject droidConSession = new ParseObject("session");
droidConSession.put("order", 13);
droidConSession.put("speakerName", "thevarun");
droidConSession.put("category", "crisptalk");
droidConSession.saveInBackground();

ParseQuery<ParseObject> query = ParseQuery.getQuery("session");
query.whereEqualTo("catgory", "crisptalk");
query.findInBackground(new FindCallback<ParseObject>(){
	public void done(List<ParseObject> sessionList, ParseException e){
		if(e == null){
			Log.d("session", "Retrieved " + sessionList.size() + " sessions");
		} else {
			Log.d("session", "Error: " + e.getMessage());
		}
	}
});




