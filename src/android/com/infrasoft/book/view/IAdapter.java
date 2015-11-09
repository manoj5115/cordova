package com.infrasoft.book.view;

import android.view.View;

public interface IAdapter {
	public int getCount();
	public BookModel getItem(int position);
	public long getItemId(int position);
	public View getView(int position);
}
