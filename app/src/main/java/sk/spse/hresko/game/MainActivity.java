package sk.spse.hresko.game;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
    private int quantity=10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // cez toto sa odkazujes na elementy v xml subore

        Button menuButton = findViewById(R.id.menu_button);

        menuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AnotherActivity.class);
                intent.putExtra("clicks", quantity);
                startActivity(intent);
            }
        });

    }



    private void display(int number) {
        TextView quantityTextView = findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    public void increase(View view) {
        quantity=quantity+10;
        display(quantity);
    }

    public void decrease(View view) {
        if (quantity > 10) {
            quantity=quantity-10;
        }
        display(quantity);
    }
}
