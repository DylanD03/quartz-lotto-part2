package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private EditText eventNameEditText, dateEditText, timeEditText, descriptionEditText, maxAttendeesEditText, maxWaitlistEditText;
    private CheckBox geolocationCheckBox;
    private Button saveButton, generateQRButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_event);

        // Initialize UI elements
        eventNameEditText = findViewById(R.id.eventNameEditText);
        dateEditText = findViewById(R.id.dateEditText);
        timeEditText = findViewById(R.id.timeEditText);
        descriptionEditText = findViewById(R.id.descriptionEditText);
        maxAttendeesEditText = findViewById(R.id.maxAttendeesEditText);
        maxWaitlistEditText = findViewById(R.id.maxWaitlistEditText);
        geolocationCheckBox = findViewById(R.id.geolocationCheckBox);
        saveButton = findViewById(R.id.saveButton);
        generateQRButton = findViewById(R.id.generateQRButton);

        // Generate QR Code button action
        generateQRButton.setOnClickListener(view -> generateQRCode());

        // Save button action
        saveButton.setOnClickListener(view -> saveEvent());
    }

    private void generateQRCode() {
        // Stub for generating QR code; assume qrCodeLink generation logic here
        String qrCodeLink = "https://example.com/qr/" + eventNameEditText.getText().toString();
        Toast.makeText(this, "QR Code Generated", Toast.LENGTH_SHORT).show();
    }

    private void saveEvent() {
        String eventName = eventNameEditText.getText().toString();
        String date = dateEditText.getText().toString();
        String time = timeEditText.getText().toString();
        String description = descriptionEditText.getText().toString();
        int maxAttendees = Integer.parseInt(maxAttendeesEditText.getText().toString());
        Integer maxWaitlist = !maxWaitlistEditText.getText().toString().isEmpty() ?
                Integer.parseInt(maxWaitlistEditText.getText().toString()) : null;
        boolean geolocationEnabled = geolocationCheckBox.isChecked();
        String qrCodeLink = "https://example.com/qr/" + eventName; // Placeholder link

        Event event = new Event(eventName, date, time, description, maxAttendees, maxWaitlist, geolocationEnabled, qrCodeLink);

        // Passing event data back to HomePageActivity
        Intent intent = new Intent();
        intent.putExtra("eventName", eventName);
        setResult(RESULT_OK, intent);
        finish();
    }

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
//        setContentView(R.layout.org_home_page);
//
//    }
}