package com.example.zeeshan.customdialerpad;

import android.content.ContentResolver;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.Toast;

public class KeyBoard extends AppCompatActivity {

    EditText EnterNumber;
    ImageButton Clear;

    Button KeyQ, KeyW, KeyE, KeyR, KeyT, KeyY, KeyU, KeyI, KeyO, KeyP;
    Button KeyA, KeyS, KeyD, KeyF, KeyG, KeyH, KeyJ, KeyK, KeyL;
    Button State, KeyZ, KeyX, KeyC, KeyV, KeyB, KeyN, KeyM, ClearLetter;
    Button KeyAt_the_rate, KeySpace, KeyDot;

    ImageButton Contacts, Keypad, Call, Menu;

    static String ContactName = "";
    static String PhoneNo = "";
    private int cursor_position = 0;

    private int state = 1;

    private AlphaAnimation buttonClick = new AlphaAnimation(1F, 0.8F);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        this.supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_key_board);

        Contacts = (ImageButton) findViewById(R.id.contacts);
        Keypad = (ImageButton) findViewById(R.id.keypad);
        Call = (ImageButton) findViewById(R.id.call);
        Menu = (ImageButton) findViewById(R.id.menu);

        EnterNumber = (EditText) findViewById(R.id.enter_number);
        EnterNumber.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });

        Clear = (ImageButton) findViewById(R.id.clear);

        KeyQ = (Button) findViewById(R.id.keyQ);
        KeyW = (Button) findViewById(R.id.keyW);
        KeyE = (Button) findViewById(R.id.keyE);
        KeyR = (Button) findViewById(R.id.keyR);
        KeyT = (Button) findViewById(R.id.keyT);
        KeyY = (Button) findViewById(R.id.keyY);
        KeyU = (Button) findViewById(R.id.keyU);
        KeyI = (Button) findViewById(R.id.keyI);
        KeyO = (Button) findViewById(R.id.keyO);
        KeyP = (Button) findViewById(R.id.keyP);

        KeyA = (Button) findViewById(R.id.keyA);
        KeyS = (Button) findViewById(R.id.keyS);
        KeyD = (Button) findViewById(R.id.keyD);
        KeyF = (Button) findViewById(R.id.keyF);
        KeyG = (Button) findViewById(R.id.keyG);
        KeyH = (Button) findViewById(R.id.keyH);
        KeyJ = (Button) findViewById(R.id.keyJ);
        KeyK = (Button) findViewById(R.id.keyK);
        KeyL = (Button) findViewById(R.id.keyL);

        State = (Button) findViewById(R.id.state);
        KeyZ = (Button) findViewById(R.id.keyZ);
        KeyX = (Button) findViewById(R.id.keyX);
        KeyC = (Button) findViewById(R.id.keyC);
        KeyV = (Button) findViewById(R.id.keyV);
        KeyB = (Button) findViewById(R.id.keyB);
        KeyN = (Button) findViewById(R.id.keyN);
        KeyM = (Button) findViewById(R.id.keyM);
        ClearLetter = (Button) findViewById(R.id.clear_letter);

        KeyAt_the_rate = (Button) findViewById(R.id.keyat_the_rate);
        KeySpace = (Button) findViewById(R.id.keyspace);
        KeyDot = (Button) findViewById(R.id.keydot);

        Clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(buttonClick);
                if (!ContactName.equals("")) {
                    ContactName = EnterNumber.getText().toString();
                    ContactName = ContactName.substring(0, ContactName.length() - 1);
                    EnterNumber.setText(ContactName);
                    cursor_position = ContactName.length();
                    EnterNumber.setSelection(cursor_position);
                } else if (!PhoneNo.equals("")) {
                    PhoneNo = EnterNumber.getText().toString();
                    PhoneNo = PhoneNo.substring(0, PhoneNo.length() - 1);
                    EnterNumber.setText(PhoneNo);
                    cursor_position = PhoneNo.length();
                    EnterNumber.setSelection(cursor_position);
                } else {
                    Toast msg = Toast.makeText(getApplicationContext(), "Please enter a name", Toast.LENGTH_SHORT);
                    msg.show();
                }
            }
        });
        Clear.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                // TODO Auto-generated method stub
                v.startAnimation(buttonClick);
                if (!ContactName.equals("")) {
                    ContactName = "";
                    EnterNumber.setText(ContactName);
                    cursor_position = ContactName.length();
                    EnterNumber.setSelection(cursor_position);
                    return true;
                } else if (!PhoneNo.equals("")) {
                    PhoneNo = "";
                    EnterNumber.setText(PhoneNo);
                    cursor_position = PhoneNo.length();
                    EnterNumber.setSelection(cursor_position);
                    return true;
                } else {
                    Toast msg = Toast.makeText(getApplicationContext(), "Please enter a valid number", Toast.LENGTH_SHORT);
                    msg.show();
                    return false;
                }
            }
        });

        State.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(buttonClick);
                if (state == 1) {
                    state = 0;

                    KeyQ.setText("q");
                    KeyW.setText("w");
                    KeyE.setText("e");
                    KeyR.setText("r");
                    KeyT.setText("t");
                    KeyY.setText("y");
                    KeyU.setText("u");
                    KeyI.setText("i");
                    KeyO.setText("o");
                    KeyP.setText("p");
                    KeyA.setText("a");
                    KeyS.setText("s");
                    KeyD.setText("d");
                    KeyF.setText("f");
                    KeyG.setText("g");
                    KeyH.setText("h");
                    KeyJ.setText("j");
                    KeyK.setText("k");
                    KeyL.setText("l");

                    State.setText("↑");

                    KeyZ.setText("z");
                    KeyX.setText("x");
                    KeyC.setText("c");
                    KeyV.setText("v");
                    KeyB.setText("b");
                    KeyN.setText("n");
                    KeyM.setText("m");

                } else {
                    state = 1;

                    KeyQ.setText("Q");
                    KeyW.setText("W");
                    KeyE.setText("E");
                    KeyR.setText("R");
                    KeyT.setText("T");
                    KeyY.setText("Y");
                    KeyU.setText("U");
                    KeyI.setText("I");
                    KeyO.setText("O");
                    KeyP.setText("P");
                    KeyA.setText("A");
                    KeyS.setText("S");
                    KeyD.setText("D");
                    KeyF.setText("F");
                    KeyG.setText("G");
                    KeyH.setText("H");
                    KeyJ.setText("J");
                    KeyK.setText("K");
                    KeyL.setText("L");

                    State.setText("▲");

                    KeyZ.setText("Z");
                    KeyX.setText("X");
                    KeyC.setText("C");
                    KeyV.setText("V");
                    KeyB.setText("B");
                    KeyN.setText("N");
                    KeyM.setText("M");
                }
            }
        });

        KeyQ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(buttonClick);
                if (state == 0)
                    ContactName = ContactName + "q";
                else
                    ContactName = ContactName + "Q";
                EnterNumber.setText(ContactName);
                cursor_position = ContactName.length();
                EnterNumber.setSelection(cursor_position);
            }
        });
        KeyW.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(buttonClick);
                if (state == 0)
                    ContactName = ContactName + "w";
                else
                    ContactName = ContactName + "W";
                EnterNumber.setText(ContactName);
                cursor_position = ContactName.length();
                EnterNumber.setSelection(cursor_position);
            }
        });
        KeyE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(buttonClick);
                if (state == 0)
                    ContactName = ContactName + "e";
                else
                    ContactName = ContactName + "E";
                EnterNumber.setText(ContactName);
                cursor_position = ContactName.length();
                EnterNumber.setSelection(cursor_position);
            }
        });
        KeyR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(buttonClick);
                if (state == 0)
                    ContactName = ContactName + "r";
                else
                    ContactName = ContactName + "R";
                EnterNumber.setText(ContactName);
                cursor_position = ContactName.length();
                EnterNumber.setSelection(cursor_position);
            }
        });
        KeyT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(buttonClick);
                if (state == 0)
                    ContactName = ContactName + "t";
                else
                    ContactName = ContactName + "T";
                EnterNumber.setText(ContactName);
                cursor_position = ContactName.length();
                EnterNumber.setSelection(cursor_position);
            }
        });
        KeyY.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(buttonClick);
                if (state == 0)
                    ContactName = ContactName + "y";
                else
                    ContactName = ContactName + "Y";
                EnterNumber.setText(ContactName);
                cursor_position = ContactName.length();
                EnterNumber.setSelection(cursor_position);
            }
        });
        KeyU.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(buttonClick);
                if (state == 0)
                    ContactName = ContactName + "u";
                else
                    ContactName = ContactName + "U";
                EnterNumber.setText(ContactName);
                cursor_position = ContactName.length();
                EnterNumber.setSelection(cursor_position);
            }
        });
        KeyI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(buttonClick);
                if (state == 0)
                    ContactName = ContactName + "i";
                else
                    ContactName = ContactName + "I";
                EnterNumber.setText(ContactName);
                cursor_position = ContactName.length();
                EnterNumber.setSelection(cursor_position);
            }
        });
        KeyO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(buttonClick);
                if (state == 0)
                    ContactName = ContactName + "o";
                else
                    ContactName = ContactName + "O";
                EnterNumber.setText(ContactName);
                cursor_position = ContactName.length();
                EnterNumber.setSelection(cursor_position);
            }
        });
        KeyP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(buttonClick);
                if (state == 0)
                    ContactName = ContactName + "p";
                else
                    ContactName = ContactName + "P";
                EnterNumber.setText(ContactName);
                cursor_position = ContactName.length();
                EnterNumber.setSelection(cursor_position);
            }
        });

        KeyA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(buttonClick);
                if (state == 0)
                    ContactName = ContactName + "a";
                else
                    ContactName = ContactName + "A";
                EnterNumber.setText(ContactName);
                cursor_position = ContactName.length();
                EnterNumber.setSelection(cursor_position);
            }
        });
        KeyS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(buttonClick);
                if (state == 0)
                    ContactName = ContactName + "s";
                else
                    ContactName = ContactName + "S";
                EnterNumber.setText(ContactName);
                cursor_position = ContactName.length();
                EnterNumber.setSelection(cursor_position);
            }
        });
        KeyD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(buttonClick);
                if (state == 0)
                    ContactName = ContactName + "d";
                else
                    ContactName = ContactName + "D";
                EnterNumber.setText(ContactName);
                cursor_position = ContactName.length();
                EnterNumber.setSelection(cursor_position);
            }
        });
        KeyF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(buttonClick);
                if (state == 0)
                    ContactName = ContactName + "f";
                else
                    ContactName = ContactName + "F";
                EnterNumber.setText(ContactName);
                cursor_position = ContactName.length();
                EnterNumber.setSelection(cursor_position);
            }
        });
        KeyG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(buttonClick);
                if (state == 0)
                    ContactName = ContactName + "g";
                else
                    ContactName = ContactName + "G";
                EnterNumber.setText(ContactName);
                cursor_position = ContactName.length();
                EnterNumber.setSelection(cursor_position);
            }
        });
        KeyH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(buttonClick);
                if (state == 0)
                    ContactName = ContactName + "h";
                else
                    ContactName = ContactName + "H";
                EnterNumber.setText(ContactName);
                cursor_position = ContactName.length();
                EnterNumber.setSelection(cursor_position);
            }
        });
        KeyJ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(buttonClick);
                if (state == 0)
                    ContactName = ContactName + "j";
                else
                    ContactName = ContactName + "J";
                EnterNumber.setText(ContactName);
                cursor_position = ContactName.length();
                EnterNumber.setSelection(cursor_position);
            }
        });
        KeyK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(buttonClick);
                if (state == 0)
                    ContactName = ContactName + "k";
                else
                    ContactName = ContactName + "K";
                EnterNumber.setText(ContactName);
                cursor_position = ContactName.length();
                EnterNumber.setSelection(cursor_position);
            }
        });
        KeyL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(buttonClick);
                if (state == 0)
                    ContactName = ContactName + "l";
                else
                    ContactName = ContactName + "L";
                EnterNumber.setText(ContactName);
                cursor_position = ContactName.length();
                EnterNumber.setSelection(cursor_position);
            }
        });

        KeyZ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(buttonClick);
                if (state == 0)
                    ContactName = ContactName + "z";
                else
                    ContactName = ContactName + "Z";
                EnterNumber.setText(ContactName);
                cursor_position = ContactName.length();
                EnterNumber.setSelection(cursor_position);
            }
        });
        KeyX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(buttonClick);
                if (state == 0)
                    ContactName = ContactName + "x";
                else
                    ContactName = ContactName + "X";
                EnterNumber.setText(ContactName);
                cursor_position = ContactName.length();
                EnterNumber.setSelection(cursor_position);
            }
        });
        KeyC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(buttonClick);
                if (state == 0)
                    ContactName = ContactName + "c";
                else
                    ContactName = ContactName + "C";
                EnterNumber.setText(ContactName);
                cursor_position = ContactName.length();
                EnterNumber.setSelection(cursor_position);
            }
        });
        KeyV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(buttonClick);
                if (state == 0)
                    ContactName = ContactName + "v";
                else
                    ContactName = ContactName + "V";
                EnterNumber.setText(ContactName);
                cursor_position = ContactName.length();
                EnterNumber.setSelection(cursor_position);
            }
        });
        KeyB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(buttonClick);
                if (state == 0)
                    ContactName = ContactName + "b";
                else
                    ContactName = ContactName + "B";
                EnterNumber.setText(ContactName);
                cursor_position = ContactName.length();
                EnterNumber.setSelection(cursor_position);
            }
        });
        KeyN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(buttonClick);
                if (state == 0)
                    ContactName = ContactName + "n";
                else
                    ContactName = ContactName + "N";
                EnterNumber.setText(ContactName);
                cursor_position = ContactName.length();
                EnterNumber.setSelection(cursor_position);
            }
        });
        KeyM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(buttonClick);
                if (state == 0)
                    ContactName = ContactName + "m";
                else
                    ContactName = ContactName + "M";
                EnterNumber.setText(ContactName);
                cursor_position = ContactName.length();
                EnterNumber.setSelection(cursor_position);
            }
        });
        ClearLetter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(buttonClick);
                if (!ContactName.equals("")) {
                    ContactName = EnterNumber.getText().toString();
                    ContactName = ContactName.substring(0, ContactName.length() - 1);
                    EnterNumber.setText(ContactName);
                    cursor_position = ContactName.length();
                    EnterNumber.setSelection(cursor_position);
                } else if (!PhoneNo.equals("")) {
                    PhoneNo = EnterNumber.getText().toString();
                    PhoneNo = PhoneNo.substring(0, PhoneNo.length() - 1);
                    EnterNumber.setText(PhoneNo);
                    cursor_position = PhoneNo.length();
                    EnterNumber.setSelection(cursor_position);
                } else {
                    Toast msg = Toast.makeText(getApplicationContext(), "Please enter a name", Toast.LENGTH_SHORT);
                    msg.show();
                }
            }
        });
        ClearLetter.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                // TODO Auto-generated method stub
                v.startAnimation(buttonClick);
                if (!ContactName.equals("")) {
                    ContactName = "";
                    EnterNumber.setText(ContactName);
                    cursor_position = ContactName.length();
                    EnterNumber.setSelection(cursor_position);
                    return true;
                } else if (!PhoneNo.equals("")) {
                    PhoneNo = "";
                    EnterNumber.setText(PhoneNo);
                    cursor_position = PhoneNo.length();
                    EnterNumber.setSelection(cursor_position);
                    return true;
                } else {
                    Toast msg = Toast.makeText(getApplicationContext(), "Please enter a valid number", Toast.LENGTH_SHORT);
                    msg.show();
                    return false;
                }
            }
        });

        KeyAt_the_rate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(buttonClick);
                ContactName = ContactName + "@";
                EnterNumber.setText(ContactName);
                cursor_position = ContactName.length();
                EnterNumber.setSelection(cursor_position);
            }
        });
        KeySpace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(buttonClick);
                ContactName = ContactName + " ";
                EnterNumber.setText(ContactName);
                cursor_position = ContactName.length();
                EnterNumber.setSelection(cursor_position);
            }
        });
        KeyDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(buttonClick);
                ContactName = ContactName + ".";
                EnterNumber.setText(ContactName);
                cursor_position = ContactName.length();
                EnterNumber.setSelection(cursor_position);
            }
        });


        Contacts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContentResolver cr = getContentResolver();
                Cursor cur = cr.query(ContactsContract.Contacts.CONTENT_URI, null, null, null, null);
                int temp = 0;
                if (cur.getCount() > 0) {
                    while (cur.moveToNext()) {
                        String id = cur.getString(cur.getColumnIndex(ContactsContract.Contacts._ID));
                        String name = cur.getString(cur.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
                        name = name.toLowerCase();
                        String searchName = EnterNumber.getText().toString().toLowerCase();
                        Log.v( EnterNumber.getText().toString(), name ); //check
                        if( name.equals(searchName))
                        {
                            Cursor phones = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = " + id, null, null);

                            if( phones.moveToFirst() )
                            {
                                String phoneNumber = phones.getString(phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                                PhoneNo = phoneNumber;
                                EnterNumber.setText(PhoneNo);

                                cursor_position = PhoneNo.length();
                                EnterNumber.setSelection(cursor_position);

                                phones.close();
                                temp = 1;
                                break;
                            }

                        }

                    }
                }
                if( temp == 0 ){

                    ContactName = "";
                    EnterNumber.setText(ContactName);
                    cursor_position = ContactName.length();
                    EnterNumber.setSelection(cursor_position);

                    Toast.makeText( getApplicationContext(), "Contact does not exist", Toast.LENGTH_LONG ).show();
                }

            }
        });

        Keypad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
            }
        });


        Call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                PhoneNo = EnterNumber.getText().toString();  // you have to change this!!!
                if (!PhoneNo.equals("")) {                  // check for Integer, +, - also
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

        Menu.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                PopupMenu popup = new PopupMenu(getApplicationContext(), Menu);
                //Inflating the Popup using xml file
                popup.getMenuInflater().inflate(R.menu.menu_inflator, popup.getMenu());

                //registering popup with OnMenuItemClickListener
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
                        if (item.getTitle().toString().equals("Home")) {
                            Log.w("1", "Its entering Home inflater Home");
                            onDestroy();
                            System.exit(0);
                        } else if (item.getTitle().toString().equals("Refresh")) {
                            EnterNumber.setText("");
                            PhoneNo = "";
                            ContactName = "";
                            Log.w("2", "Its entering Home inflater Refresh");
                            Intent i = new Intent(getApplicationContext(), KeyBoard.class);
                            startActivity(i);
                        } else {
                            Log.w("3", "Its entering Home inflater Close");
                            finish();
                            System.exit(0);
                        }
                        return true;
                    }
                });

                popup.show();//showing popup menu
            }
        });//closing the setOnClickListener method

    }

}