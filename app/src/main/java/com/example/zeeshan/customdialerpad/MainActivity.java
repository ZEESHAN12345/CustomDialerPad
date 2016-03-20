package com.example.zeeshan.customdialerpad;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.database.Cursor;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.Toast;
import android.view.animation.AlphaAnimation;
import android.view.View.OnTouchListener;
import android.view.MotionEvent;

public class MainActivity extends AppCompatActivity {

    EditText EnterNumber;
    Button Key1, Key2, Key3, Key4, Key5, Key6, Key7, Key8, Key9, KeyStar, Key0, KeyHash;
    ImageButton Clear, Contacts, Keyboard, Call, Menu;

    static String PhoneNo = "";
    public static final int PICK_CONTACT = 1;

    private int cursor_position = 0;

    private AlphaAnimation buttonClick = new AlphaAnimation(1F, 0.8F); //button effect

    private AudioManager myAudio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_main);

        EnterNumber = (EditText)findViewById(R.id.enter_number);
        EnterNumber.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });

        Key1 = (Button)findViewById(R.id.key1);
        Key2 = (Button)findViewById(R.id.key2);
        Key3 = (Button)findViewById(R.id.key3);
        Key4 = (Button)findViewById(R.id.key4);
        Key5 = (Button)findViewById(R.id.key5);
        Key6 = (Button)findViewById(R.id.key6);
        Key7 = (Button)findViewById(R.id.key7);
        Key8 = (Button)findViewById(R.id.key8);
        Key9 = (Button)findViewById(R.id.key9);
        KeyStar = (Button)findViewById(R.id.keystar);
        Key0 = (Button)findViewById(R.id.key0);
        KeyHash = (Button)findViewById(R.id.keyhash);

        SpannedString.desired(Key1, "∞");
        Key1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(buttonClick);
                PhoneNo = PhoneNo + "1";
                EnterNumber.setText(PhoneNo);
                cursor_position = PhoneNo.length();
                EnterNumber.setSelection(cursor_position);
            }
        });

        SpannedString.desired(Key2, "ABC");
        Key2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(buttonClick);
                PhoneNo = PhoneNo + "2";
                EnterNumber.setText(PhoneNo);
                cursor_position = PhoneNo.length();
                EnterNumber.setSelection(cursor_position);
            }
        });

        SpannedString.desired(Key3, "DEF");
        Key3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(buttonClick);
                PhoneNo = PhoneNo + "3";
                EnterNumber.setText(PhoneNo);
                cursor_position = PhoneNo.length();
                EnterNumber.setSelection(cursor_position);
            }
        });

        SpannedString.desired(Key4, "GHI");
        Key4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(buttonClick);
                PhoneNo = PhoneNo + "4";
                EnterNumber.setText(PhoneNo);
                cursor_position = PhoneNo.length();
                EnterNumber.setSelection(cursor_position);
            }
        });

        SpannedString.desired(Key5, "JKL");
        Key5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(buttonClick);
                PhoneNo = PhoneNo + "5";
                EnterNumber.setText(PhoneNo);
                cursor_position = PhoneNo.length();
                EnterNumber.setSelection(cursor_position);
            }
        });

        SpannedString.desired(Key6, "MNO");
        Key6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(buttonClick);
                PhoneNo = PhoneNo + "6";
                EnterNumber.setText(PhoneNo);
                cursor_position = PhoneNo.length();
                EnterNumber.setSelection(cursor_position);
            }
        });

        SpannedString.desired(Key7, "PQRS");
        Key7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(buttonClick);
                PhoneNo = PhoneNo + "7";
                EnterNumber.setText(PhoneNo);
                cursor_position = PhoneNo.length();
                EnterNumber.setSelection(cursor_position);
            }
        });

        SpannedString.desired(Key8, "TUV");
        Key8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(buttonClick);
                PhoneNo = PhoneNo + "8";
                EnterNumber.setText(PhoneNo);
                cursor_position = PhoneNo.length();
                EnterNumber.setSelection(cursor_position);
            }
        });

        SpannedString.desired(Key9, "WXYZ");
        Key9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(buttonClick);
                PhoneNo = PhoneNo + "9";
                EnterNumber.setText(PhoneNo);
                cursor_position = PhoneNo.length();
                EnterNumber.setSelection(cursor_position);
            }
        });

        KeyStar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(buttonClick);
                PhoneNo = PhoneNo + "*";
                EnterNumber.setText(PhoneNo);
                cursor_position = PhoneNo.length();
                EnterNumber.setSelection(cursor_position);
            }
        });

        SpannedString.desired(Key0, "+");
        Key0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(buttonClick);
                PhoneNo = PhoneNo + "0";
                EnterNumber.setText(PhoneNo);
                cursor_position = PhoneNo.length();
                EnterNumber.setSelection(cursor_position);
            }
        });
        Key0.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                // TODO Auto-generated method stub
                PhoneNo = PhoneNo + "+";
                EnterNumber.setText(PhoneNo);
                cursor_position = PhoneNo.length();
                EnterNumber.setSelection(cursor_position);

                return true;
            }
        });

        SpannedString.desired(KeyHash, "♪");
        KeyHash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(buttonClick);
                PhoneNo = PhoneNo + "#";
                EnterNumber.setText(PhoneNo);
                cursor_position = PhoneNo.length();
                EnterNumber.setSelection(cursor_position);
            }
        });
        KeyHash.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                // TODO Auto-generated method stub
                v.startAnimation(buttonClick);

                myAudio = (AudioManager) getApplicationContext().getSystemService(Context.AUDIO_SERVICE);

                if(myAudio.getRingerMode()==AudioManager.RINGER_MODE_NORMAL)
                myAudio.setRingerMode(AudioManager.RINGER_MODE_VIBRATE);

                else if(myAudio.getRingerMode()==AudioManager.RINGER_MODE_VIBRATE)
                    myAudio.setRingerMode(AudioManager.RINGER_MODE_SILENT);

                else
                    myAudio.setRingerMode(AudioManager.RINGER_MODE_NORMAL);

                return true;
            }
        });



        EnterNumber.requestFocus(); //touch hide keypad not working
        EnterNumber.postDelayed(new Runnable() {
            public void run() {
                InputMethodManager keyboard = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                keyboard.hideSoftInputFromWindow(EnterNumber.getWindowToken(), 0);
            }
        }, 200);

        Clear = (ImageButton)findViewById(R.id.clear);
        Clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(buttonClick);
                if (!PhoneNo.equals("")) {
                    PhoneNo = EnterNumber.getText().toString();
                    PhoneNo = PhoneNo.substring(0, PhoneNo.length() - 1);
                    EnterNumber.setText(PhoneNo);
                    cursor_position = PhoneNo.length();
                    EnterNumber.setSelection(cursor_position);
                } else {
                    Toast msg = Toast.makeText(getApplicationContext(), "Please enter a number", Toast.LENGTH_SHORT);
                    msg.show();
                }
            }
        });
        Clear.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                // TODO Auto-generated method stub
                v.startAnimation(buttonClick);
                if (!PhoneNo.equals("")) {
                    PhoneNo = "";
                    EnterNumber.setText(PhoneNo);
                    cursor_position = PhoneNo.length();
                    EnterNumber.setSelection(cursor_position);
                    return  true;
                } else {
                    Toast msg = Toast.makeText(getApplicationContext(), "Please enter a number", Toast.LENGTH_SHORT);
                    msg.show();
                    return false;
                }
            }
        });


        Keyboard = (ImageButton)findViewById(R.id.keyboard);
        Keyboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), KeyBoard.class);
                startActivity(i);
            }
        });


        Call = (ImageButton)findViewById(R.id.call);
        Call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    PhoneNo = EnterNumber.getText().toString();
                if (!PhoneNo.equals("")) {
                    Intent callIntent = new Intent(Intent.ACTION_CALL);
                    callIntent.setData(Uri.parse("tel:" + PhoneNo));
                    try {
                        startActivity(callIntent);
                    } catch (android.content.ActivityNotFoundException exception) {
                        Toast msg = Toast.makeText(getApplicationContext(), "your Activity is not founded!", Toast.LENGTH_SHORT);
                        msg.show();
                    }
                } else {
                    Toast msg = Toast.makeText(getApplicationContext(), "No number is entered", Toast.LENGTH_SHORT);
                    msg.show();
                }

            }
        });

        Menu = (ImageButton)findViewById(R.id.menu);
        Menu.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                PopupMenu popup = new PopupMenu(getApplicationContext(), Menu);
                //Inflating the Popup using xml file
                popup.getMenuInflater().inflate(R.menu.menu_inflator , popup.getMenu());

                //registering popup with OnMenuItemClickListener
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
                        if(item.getTitle().toString().equals("Home")) {
                            Log.w("1", "Its entering Home inflater Home");
                            onDestroy();
                            System.exit(0);
                        }
                        else if(item.getTitle().toString().equals("Refresh")) {
                            Log.w("2", "Its entering Home inflater Refresh");
                            Intent i = new Intent(getApplicationContext(), MainActivity.class);
                            startActivity(i);
                        }
                        else {
                            Log.w("3", "Its entering Home inflater Close");
                            finish();
                            System.exit(0);
                        }
                        return true;
                    }
                });

                popup.show();
            }
        });


        Contacts = (ImageButton)findViewById(R.id.contacts);
        Contacts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent contactPickerIntent = new Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI);
                startActivityForResult(contactPickerIntent, PICK_CONTACT);

            }
        });
    }

    @Override
    public void onActivityResult(int reqCode, int resultCode, Intent data) {
        super.onActivityResult(reqCode, resultCode, data);

        switch (reqCode) {
            case (PICK_CONTACT) :
                if (resultCode == Activity.RESULT_OK) {
                    Uri contactData = data.getData();
                    Cursor c =  getContentResolver().query(contactData, null, null, null, null);

                    if (c.moveToFirst()) {

                        //String name = c.getString(c.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
                        String id = c.getString(c.getColumnIndex(ContactsContract.Contacts._ID));
                        Cursor phones = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = " + id, null, null);
                        EnterNumber.setText( "" );
                        if( phones.moveToFirst() )
                        {
                            String phoneNumber = phones.getString(phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                            PhoneNo = phoneNumber;
                            if (!PhoneNo.equals("")) {
                                Log.w("Error: ", "No Error");
                                EnterNumber.setText(phoneNumber);
                                cursor_position = PhoneNo.length();
                                EnterNumber.setSelection(cursor_position);
                            } else {
                                Toast msg = Toast.makeText(getApplicationContext(), "Please enter a number", Toast.LENGTH_SHORT);
                                msg.show();
                            }

                        }
                        phones.close();
                        // TODO Whatever you want to do with the selected contact name.
                    }
                }
                break;
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

}