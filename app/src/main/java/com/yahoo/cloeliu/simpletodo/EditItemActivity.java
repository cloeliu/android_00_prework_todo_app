package com.yahoo.cloeliu.simpletodo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;


public class EditItemActivity extends Activity {

    private int pos = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);

        pos = getIntent().getIntExtra("pos", 0);
        String itemText = getIntent().getStringExtra("text");
        EditText etEditItem = (EditText) findViewById(R.id.etEditItem);
        etEditItem.setText(itemText);
        etEditItem.setSelection(itemText.length());
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_edit_item, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onEditItem(View view) {
        EditText etEditItem = (EditText) findViewById(R.id.etEditItem);
        String itemText = etEditItem.getText().toString();
        Intent data = new Intent();
        data.putExtra("newItemName", itemText);
        data.putExtra("itemPos", pos);
        setResult(RESULT_OK, data);
        finish();
    }
}
