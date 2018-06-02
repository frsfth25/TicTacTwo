package com.example.farisfathurrahman25.tictactwo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    //String TAG = "";

    static int playerTurn = 1;

    static int[][] gridField =
            {
                    {0, 0, 0},
                    {0, 0, 0},
                    {0, 0, 0}
            };
    Button buttonClick;
    GridView gridView;
    ArrayList gridItems;
    private List<Element> elementList;
    private ElementAdapter elementAdapter;
    AdapterView.OnItemClickListener onGridClick = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            StringBuilder sb = new StringBuilder();
            sb.append("x: ").append(position % 3).append(", y: ").append(position / 3);
            //Toast.makeText(getApplicationContext(), sb.toString(), Toast.LENGTH_SHORT).show();

            if ((int) gridItems.get(position) == 1 || (int) gridItems.get(position) == 2) {
                Toast.makeText(getApplicationContext(), "Already filled!", Toast.LENGTH_SHORT).show();
                return;
            }

            Random rand = new Random();
            boolean found = false;
            int filledCounter = 0;
            while (!found || filledCounter == gridItems.size()) {
                int idx = rand.nextInt(((gridItems.size() - 1 - 0) + 1) + 0);
                if ((int) gridItems.get(idx) != 0) {
                    filledCounter++;
                    continue;
                }
                //int row = rand.nextInt(((2) + 1));
                //int col = rand.nextInt(((2) + 1));
                gridItems.set(idx, 1);
                found = true;
            }


            elementList = new ArrayList<>();

            switch ((int) gridItems.get(position)) {
                default:
                    gridItems.set(position, 2);
                    break;
            }


            for (int i = 0; i < gridItems.size(); i++) {
                switch ((int) gridItems.get(i)) {
                    case 1: // circle
                        elementList.add(new Element(R.drawable.circle_box, "Circle", "Circle symbol"));
                        break;
                    case 2: // cross
                        elementList.add(new Element(R.drawable.cross_box, "Cross", "Cross symbol"));
                        break;
                    default: // blank
                        elementList.add(new Element(R.drawable.blank_box, "Blank", "Blank symbol"));
                        break;
                }
            }

            elementAdapter = new ElementAdapter(MainActivity.this, R.layout.element_item, elementList);
            gridView.setAdapter(elementAdapter);

            if (checkGameStatus())
                return;
        }

        public boolean checkGameStatus() {
            //
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonClick = findViewById(R.id.testBtn);

        gridView = findViewById(R.id.sceneGrid);

        drawGrid(gridField);

        gridItems = new ArrayList<Integer>(); //3x3
        for (int i = 0; i < gridField.length; i++) {
            for (int j = 0; j < gridField[i].length; j++) {
                gridItems.add(0);
            }
        }
    }

    private void drawGrid(int[][] inputGrid) {
        elementList = new ArrayList<>();

        for (int i = 0; i < inputGrid.length; i++)
            for (int j = 0; j < inputGrid[i].length; j++) {
                switch (inputGrid[i][j]) {
                    case 1: // circle
                        elementList.add(new Element(R.drawable.circle_box, "Circle", "Circle symbol"));
                        break;
                    case 2: // cross
                        elementList.add(new Element(R.drawable.cross_box, "Cross", "Cross symbol"));
                        break;
                    default: // blank
                        elementList.add(new Element(R.drawable.blank_box, "Blank", "Blank symbol"));
                        break;
                }
            }

        elementAdapter = new ElementAdapter(this, R.layout.element_item, elementList);
        gridView.setAdapter(elementAdapter);

        //register scene item click
        gridView.setOnItemClickListener(onGridClick);
    }

    public void onClickBtn(View view) {
        Random rand = new Random();
        int num = rand.nextInt(((2) + 1));
        Toast.makeText(this, "" + num, Toast.LENGTH_SHORT).show();
    }
}
