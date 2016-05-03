package com.mac.chris.sqlitedatabaseshelper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ButtonBarLayout;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.mac.chris.sqlitedatabaseshelper.model.Post;
import com.mac.chris.sqlitedatabaseshelper.model.User;

import org.w3c.dom.Text;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText editTextUserName;
    Button button;
    TextView results;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextUserName = (EditText) findViewById(R.id.edittext_enter_name);
        results = (TextView) findViewById(R.id.textview_display_data);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        // Create sample data
        User sampleUser = new User();
        sampleUser.userName = "Steph";
        //sampleUser.profilePictureUrl = "https://i.imgur.com/tGbaZCY.jpg";

        Post samplePost = new Post();
        samplePost.user = sampleUser;
        samplePost.text = "Won won!";

        // Get singleton instance of database
        MyDatabaseHelper databaseHelper = MyDatabaseHelper.getInstance(this);

        // Add sample post to the database
        databaseHelper.addPost(samplePost);

        // Get all posts from database
        List<Post> posts = databaseHelper.getAllPosts();
        for (Post post : posts) {
            results.setText(post.user.userName+"\n\n"+post.text);
        }
    }
}
