package lt.vtvpmc.ems.zp182.factorial;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.math.BigInteger;

public class MainActivity extends AppCompatActivity {

    private TextView infoResult;
    private EditText inputNumberField;
    private Button buttonResult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        infoResult = (TextView) findViewById(R.id.infoResult);
        inputNumberField = (EditText) findViewById(R.id.inputNumberField);
        buttonResult = (Button) findViewById(R.id.buttonResult);

        buttonResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BigInteger number = new BigInteger(inputNumberField.getText().toString());
                BigInteger factorial = calcFactorial(number);
                String result = String.format("Factorial of %d is equal to %d", number, factorial);
                infoResult.setText(result);

            }
        });

    }

    private BigInteger factorial(BigInteger number) {
        if (number.compareTo(BigInteger.ONE) == -1) {
            return BigInteger.ONE;
        } else {
            return number.multiply(factorial(number.subtract(BigInteger.ONE)));
        }
    }

    private BigInteger calcFactorial(BigInteger number) {
        BigInteger sum = BigInteger.ONE;
//        for (BigInteger i = number; i.compareTo(BigInteger.ZERO) == 1; i = i.subtract(BigInteger.ONE)) {
//            sum = sum.add(i.multiply(i.subtract(BigInteger.ONE)));
//        }

        while (number.compareTo(BigInteger.ZERO) == 1) {
            sum = sum.add(sum.multiply(number.subtract(BigInteger.ONE)));
            number = number.subtract(BigInteger.ONE);
        }

        return sum;
    }
}