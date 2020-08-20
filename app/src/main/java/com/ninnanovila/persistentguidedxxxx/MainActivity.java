package com.ninnanovila.persistentguidedxxxx;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.google.android.material.textfield.TextInputEditText;
import com.ninnanovila.persistentguidedxxxx.adapter.UserRecyclerViewAdapter;
import com.ninnanovila.persistentguidedxxxx.database.DatabaseClient;
import com.ninnanovila.persistentguidedxxxx.model.User;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText editText;
    private Button addBtn;
    private RecyclerView recyclerView;
    private SwipeRefreshLayout refreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.input_name);
        addBtn = findViewById(R.id.btn_add);
        refreshLayout = findViewById(R.id.swipe_refresh);
        recyclerView = findViewById(R.id.user_rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addUser();
            }
        });

        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getUsers();
                refreshLayout.setRefreshing(false);
            }
        });

        getUsers();
    }

    private void getUsers(){
        class GetUsers extends AsyncTask<Void, Void, List<User>>{

            @Override
            protected List<User> doInBackground(Void... voids) {
                List<User> userList = DatabaseClient
                        .getInstance(getApplicationContext())
                        .getDatabase()
                        .userDao()
                        .getAll();
                return userList;
            }

            @Override
            protected void onPostExecute(List<User> users) {
                super.onPostExecute(users);
                UserRecyclerViewAdapter adapter = new UserRecyclerViewAdapter(MainActivity.this, users);
                recyclerView.setAdapter(adapter);
                if (users.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Empty List", Toast.LENGTH_SHORT).show();
                }
            }
        }

        GetUsers get = new GetUsers();
        get.execute();
    }

    private void addUser(){
        final String name = editText.getText().toString();

        class AddUser extends AsyncTask<Void, Void, Void>{

            @Override
            protected Void doInBackground(Void... voids) {
                User user = new User();
                user.setFullName(name);

                DatabaseClient.getInstance(getApplicationContext()).getDatabase()
                        .userDao()
                        .insert(user);
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                Toast.makeText(getApplicationContext(), "User saved", Toast.LENGTH_SHORT).show();
                editText.setText("");
                getUsers();
            }
        }

        AddUser add = new AddUser();
        add.execute();
    }
}

