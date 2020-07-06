package kr.co.tjoeun.androidintent_20200706

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

            dialBtn.setOnClickListener {

                //입력한 폰번 받아오기
                val inputPhoneNum = phoneNumEdt.text.toString()

                //어디로 전화를 걸지 정보 저장 변수 => Uri
                //parse = String을 변환
                val myUri = Uri.parse("tel:${inputPhoneNum}")

                //실제 전화 화면으로 이동시켜줄 Intent
                //어떤 행동을 할지 종류, 세부정보
                val myIntent = Intent(Intent.ACTION_DIAL, myUri)

                //액티비티 실행
                startActivity(myIntent)
            }

            callBtn.setOnClickListener {

                val inputPhone = phoneNumEdt.text.toString()

                val myUri = Uri.parse("tel:${inputPhone}")

                val myIntent = Intent(Intent.ACTION_CALL, myUri)


                startActivity(myIntent)
            }

            smsBtn.setOnClickListener {

                val inputPhone = phoneNumEdt.text.toString()

                val inputContent = smsContentEdt.text.toString()

                val myUri = Uri.parse("smsto:${inputPhone}")

                val myIntent = Intent(Intent.ACTION_SENDTO, myUri)

                //입력한 내용을 putExtra,로 들고가자  (sms_body라고 정해져 있음)
                myIntent.putExtra("sms_body", inputContent)
                startActivity(myIntent)
            }



    }
}