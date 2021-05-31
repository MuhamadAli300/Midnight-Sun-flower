package com.muhammadali.midnightsunflower

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_about.*

class AboutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        val body = """Midnight Sunflower:
A Book of Poetry by Sayyid Umar Kh. from Uzbekistan written in 2021
Copyrights©:
All rights reserved. No part of this publication may be reproduced, distributed, or transmitted in any form or by any means, including photocopying, recording, or other electronic or mechanical methods, without the prior written permission of the publisher, except in the case of brief quotations embodied in critical reviews and certain other noncommercial uses permitted by copyright law.
This App:
Created by Muhammad Ali
Email: muhammadali181025@gmail.com"""

        tvBodyAbout.text = body

        tvBackToBookFromAbout.setOnClickListener {
            val intent = Intent(this@AboutActivity, BookActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}