package com.brandeis.todolist;

import android.app.Activity;

import java.util.ArrayList;

import android.util.Log;
import android.widget.Button;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

public class ToDoListActivity extends Activity {
	String tag = "Events";
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_to_do_list);
		Log.d(tag, "In the onCreate() Event");
		
		ListView myListView = (ListView)findViewById(R.id.myListView);
		final EditText myEditText = (EditText)findViewById(R.id.myEditText);
		
		final ArrayList<String> todoItems = new ArrayList<String>();
		final ArrayAdapter<String> aa;
		
		aa = new ArrayAdapter<String>(this,
									  android.R.layout.simple_list_item_1,
									  todoItems) ;
		myListView.setAdapter(aa);
		
		myEditText.setOnKeyListener(new View.OnKeyListener() {
		public boolean onKey(View v, int keyCode, KeyEvent event) {
			if (event.getAction() == KeyEvent.ACTION_DOWN)
				if ((keyCode == KeyEvent.KEYCODE_DPAD_CENTER) || 
				    (keyCode == KeyEvent.KEYCODE_ENTER)) {
			todoItems.add(0, myEditText.getText().toString());
			aa.notifyDataSetChanged();
			myEditText.setText("");
			return true;
		}
		return false;
		}
		});
		
		Button button = (Button)findViewById(R.id.myButton);
		
		button.setOnClickListener(new Button.OnClickListener(){
			
			public void onClick(View arg0) {
				Intent intent = new Intent();
				intent.setClass(ToDoListActivity.this, ProfilePage.class);
				startActivity(intent);
				//ToDoListActivity.this.finish();
			}
		});
		
		
		
		
	}
	
	public void onStart()
	{
		super.onStart();
		Log.d(tag, "In the onStart() event");
	}
	
	public void onRestart()
	{
		super.onRestart();
		Log.d(tag, "In the onRestart() event");
	}
	
	public void onResume()
	{
		super.onResume();
		Log.d(tag, "In the onResume() event");
		Log.d(tag, "just for github test");
	}
	
	public void onPause(){
		super.onPause();
		Log.d(tag, "In the onPause() event");
	}
	
	public void onStop(){
		super.onStop();
		Log.d(tag, "In the onStop() event");
	}
	
	public void onDestroy(){
		super.onDestroy();
		Log.d(tag, "In the onDestroy() event");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.to_do_list, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
