package com.infrasoft.book.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.TextView;

//import com.example.hello.R;
import com.infrasoft.book.MainActivity;

import java.util.ArrayList;
import java.util.List;


public class BookAdapter implements com.infrasoft.book.view.IAdapter {
	private List<String> strList = new ArrayList<String>();
	
	private Context mContext;
    private List<BookModel> bookPages;

    public BookAdapter(Context context) {
		super();
		this.mContext = context;
	}
	public void addItem(List<String> list){
		strList.addAll(list);
	}
	public int getCount() {
		return bookPages.size();
	}

	public BookModel getItem(int position) {
		return bookPages.get(position);
	}

	public long getItemId(int position) {
		return position;
	}

	public View getView(int position) {
		/*TextView textView = new TextView(mContext);
		textView.setText(strList.get(position));
		textView.setTextColor(Color.BLACK);
		textView.setBackgroundColor(Color.WHITE);
		textView.setBackgroundResource(R.drawable.ly);
		textView.setPadding(10, 10, 10, 10);
		textView.setLayoutParams(new FrameLayout.LayoutParams(LayoutParams.FILL_PARENT,LayoutParams.FILL_PARENT));
		return textView;*/
        String package_name = ((MainActivity)mContext).getApplication().getPackageName();
        Resources res = ((MainActivity)mContext).getApplication().getResources();

        BookModel b = bookPages.get(position);
		//View page = ((MainActivity)mContext).getLayoutInflater().inflate(R.layout.page_layout, null);
		int pageLayoutId = res.getIdentifier("page_layout", "layout", package_name);
        int titleTextTd = res.getIdentifier("titleText", "id", package_name);
        int contentTextId = res.getIdentifier("contentText", "id", package_name);
        int lyDrawableTd = res.getIdentifier("ly", "drawable", package_name);
		View page = ((MainActivity)mContext).getLayoutInflater().inflate(pageLayoutId, null);
		if(b == null){
            return page;
        }
        TextView title = (TextView) page.findViewById(titleTextTd);
        title.setText(b.getTitle());

		TextView content = (TextView) page.findViewById(contentTextId);
		content.setText(b.getContent());
		content.setTextColor(Color.BLACK);
		page.setBackgroundColor(Color.WHITE);
		page.setBackgroundResource(lyDrawableTd);
		page.setPadding(10, 10, 10, 10);
		page.setLayoutParams(new FrameLayout.LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT));
		return page;
	}

    public void setData(List<BookModel> bookPages) {
        this.bookPages = bookPages;
    }
}
