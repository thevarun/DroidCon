package vt.droidcon;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.parse.ParseObject;
import com.parse.ParseQueryAdapter;
import com.vt.droidcon.R;

public class MyParseCloudAdapter extends ParseQueryAdapter<Post> {

	public MyParseCloudAdapter(Context context,
			Class<? extends ParseObject> clazz) {
		super(context, clazz);
		// TODO Auto-generated constructor stub
	}

	@Override
	public View getItemView(Post post, View v, ViewGroup parent) {
	 
	    if (v == null) {
	        v = View.inflate(getContext(), R.layout.postlistitem, null);
	    }
	 
	    super.getItemView(post, v, parent);
	 
	    TextView userView = (TextView) v.findViewById(R.id.postitem_username);
	    TextView contentView = (TextView) v.findViewById(R.id.postitem_content);

	    userView.setText(post.getAuthorName());
	    contentView.setText(post.getTitle());
	    
	    return v;
	}

	
	
}
