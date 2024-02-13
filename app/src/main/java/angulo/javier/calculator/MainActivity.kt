package angulo.javier.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    // 0 -> nothing, 1 -> Addition, 2 -> Subtraction, 3 -> Multiplication, 4 -> Division
    var op: Int = 0
    var number1: Double = 0.0
    lateinit var tv_num1: TextView
    lateinit var tv_num2: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tv_num1 = findViewById(R.id.tv_num1)
        tv_num2 = findViewById(R.id.tv_num2)
        val btnC: Button = findViewById(R.id.btnC)
        val btnEquals: Button = findViewById(R.id.btnEquals)

        btnEquals.setOnClickListener {
            var number2: Double = tv_num2.text.toString().toDouble()
            var res: Double = 0.0

            when(op) {
                1 -> res = number1 + number2
                2 -> res = number1 - number2
                3 -> res = number1 * number2
                4 -> res = number1 / number2
            }

            tv_num2.setText(res.toString())
            tv_num1.setText("")
        }

        btnC.setOnClickListener {
            tv_num1.setText("")
            tv_num2.setText("")
            number1 = 0.0
            op = 0
        }
    }

    fun pressDigit(view: View) {
        var num2: String = tv_num2.text.toString()

        when(view.id) {
            R.id.btn0 -> tv_num2.setText(num2 + "0")
            R.id.btn1 -> tv_num2.setText(num2 + "1")
            R.id.btn2 -> tv_num2.setText(num2 + "2")
            R.id.btn3 -> tv_num2.setText(num2 + "3")
            R.id.btn4 -> tv_num2.setText(num2 + "4")
            R.id.btn5 -> tv_num2.setText(num2 + "5")
            R.id.btn6 -> tv_num2.setText(num2 + "6")
            R.id.btn7 -> tv_num2.setText(num2 + "7")
            R.id.btn8 -> tv_num2.setText(num2 + "8")
            R.id.btn9 -> tv_num2.setText(num2 + "9")
            R.id.btnDecimal -> tv_num2.setText(num2 + ".")
        }
    }

    fun clickOperator(view: View) {
        number1 = tv_num2.text.toString().toDouble()
        var num2_text: String = tv_num2.text.toString()
        tv_num2.setText("")

        when(view.id) {
            R.id.btnAdd -> {
                tv_num1.setText(num2_text + "+")
                op = 1
            }
            R.id.btnSub -> {
                tv_num1.setText(num2_text + "-")
                op = 2
            }
            R.id.btnMulti -> {
                tv_num1.setText(num2_text + "*")
                op = 3
            }
            R.id.btnDiv -> {
                tv_num1.setText(num2_text + "/")
                op = 4
            }
        }
    }
}