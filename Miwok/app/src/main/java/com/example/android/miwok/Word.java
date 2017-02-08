package com.example.android.miwok;

/**
 * Created by Vishwajeet on 11/1/17.
 */


/**
 * {@link Word} Represents a vocabulary word which user want to learn. It contains default translation as well as miwok
 * translation of the word.
 */
public class Word {

    /*English translation of word*/
    private String mEnglishTranslation;

    /*Miwok translation of word*/
    private String mMiwokTranslation;

    private int mImageResourceId = NO_IMAGE_PROVIDED;

    private int mAudioResourceId;

    private static final int NO_IMAGE_PROVIDED = -1;

    public Word(String englishTranslation, String miwokTranslation, int audioResourceId){
        mEnglishTranslation = englishTranslation;
        mMiwokTranslation = miwokTranslation;
        mAudioResourceId = audioResourceId;
    }

    public Word(String englishTranslation, String miwokTranslation, int imageResourceId, int audioResourceId){
        mEnglishTranslation = englishTranslation;
        mMiwokTranslation = miwokTranslation;
        mImageResourceId = imageResourceId;
        mAudioResourceId = audioResourceId;
    }

    /*Get English translation of word*/
    public String getEnglishTranslation(){
        return mEnglishTranslation;
    }

    /*Get Miwok Translation of word*/
    public String getMiwokTranslation(){
        return mMiwokTranslation;
    }

    public int getImageResourceId(){
        return mImageResourceId;
    }

    public boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }

    public int getmAudioResourceId() {
        return mAudioResourceId;
    }
}
