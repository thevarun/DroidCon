package vt.droidcon;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.parse.ParseQueryAdapter;
import com.vt.droidcon.R;

public class PostListActivity extends ListActivity {

	private ParseQueryAdapter<Post> mainAdapter;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getListView().setClickable(false);

		mainAdapter = new ParseQueryAdapter<Post>(this, Post.class);
		mainAdapter.setTextKey("title");
		mainAdapter.setImageKey("photo");

		// Default view is all meals
		setListAdapter(mainAdapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_meal_list, menu);
		return true;
	}

	/*
	 * Posting meals and refreshing the list will be controlled from the Action
	 * Bar.
	 */
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {

		case R.id.action_refresh: {
			updatePostList();
			break;
		}


		case R.id.action_new: {
			newPost();
			break;
		}
		}
		return super.onOptionsItemSelected(item);
	}

	private void updatePostList() {
		mainAdapter.loadObjects();
		setListAdapter(mainAdapter);
	}

	private void newPost() {
		Intent i = new Intent(this, NewPostActivity.class);
		startActivityForResult(i, 0);
	}

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (resultCode == Activity.RESULT_OK) {
			// If a new post has been added, update
			// the list of posts
			updatePostList();
		}
	}

}
