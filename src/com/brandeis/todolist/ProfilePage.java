package com.brandeis.todolist;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class ProfilePage extends Activity{
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		
		
		setContentView(R.layout.profile_page);
		Button button = (Button)findViewById(R.id.button1);
		
		button.setOnClickListener(new Button.OnClickListener(){
			public void onClick(View arg0){
				Intent intent = new Intent();
				
				intent.setClass(ProfilePage.this, ToDoListActivity.class);
				startActivity(intent);
				ProfilePage.this.finish();
			}
		});
		
	}
}
