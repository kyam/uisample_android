package com.example.okatsu.testapp01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.app.DialogFragment;
import android.view.View;
import android.widget.CheckBox;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.toggleButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleClickEvent(v);
            }
        });

        findViewById(R.id.checkBox).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkBoxClickEvent(v);
            }
        });

    }

    private void toggleClickEvent(View v) {
        // ダイアログを表示する
        DialogFragment newFragment = new TestDialogFragment();
        Bundle args = new Bundle();
        args.putString("dialogTitle", "トグルしたよ");
        newFragment.setArguments(args);
        newFragment.show(getFragmentManager(), "test");
    }

    private void checkBoxClickEvent(View v) {
        DialogFragment newFragment = new TestDialogFragment();

        final boolean checked = ((CheckBox)v).isChecked();

        if (checked) {
            Bundle args = new Bundle();
            args.putString("dialogTitle", "チェックしたよ");
            newFragment.setArguments(args);
            newFragment.show(getFragmentManager(), "test");
        } else {
            Bundle args = new Bundle();
            args.putString("dialogTitle", "チェック外したよ");
            newFragment.setArguments(args);
            newFragment.show(getFragmentManager(), "test");
        }
    }

    public static class TestDialogFragment extends DialogFragment {
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            String title = getArguments().getString("dialogTitle");

            // Use the Builder class for convenient dialog construction
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder.setMessage(title)
                    .setPositiveButton("はい", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            // FIRE ZE MISSILES!
                        }
                    })
                    .setNegativeButton("キャンセル", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            // User cancelled the dialog
                        }
                    });
            // Create the AlertDialog object and return it
            return builder.create();
        }
    }
}

