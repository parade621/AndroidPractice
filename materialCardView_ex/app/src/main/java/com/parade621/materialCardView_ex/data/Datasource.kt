package com.parade621.materialCardView_ex.data

import com.parade621.materialCardView_ex.R
import com.parade621.materialCardView_ex.model.Affirmation

class Datasource{

    fun loadAffirmations(): List<Affirmation>{
        return listOf<Affirmation>(
            Affirmation(R.string.affirmation1,R.drawable.cv_image1),
            Affirmation(R.string.affirmation2,R.drawable.cv_image2),
            Affirmation(R.string.affirmation3,R.drawable.cv_image3),
            Affirmation(R.string.affirmation4,R.drawable.cv_image4),
            Affirmation(R.string.affirmation5,R.drawable.cv_image5),
            Affirmation(R.string.affirmation6,R.drawable.cv_image6),
            Affirmation(R.string.affirmation7,R.drawable.cv_image7),
            Affirmation(R.string.affirmation8,R.drawable.cv_image8),
            Affirmation(R.string.affirmation9,R.drawable.cv_image9),
            Affirmation(R.string.affirmation10,R.drawable.cv_image10)
        )
    }
}