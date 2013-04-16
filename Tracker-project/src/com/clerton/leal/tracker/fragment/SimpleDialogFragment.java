package com.clerton.leal.tracker.fragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;

import com.clerton.leal.tracker.R;

/**
 * 
 * @author clertonleal@gmail.com
 * @since 24/03/2013
 */
public class SimpleDialogFragment extends DialogFragment {

	private OnClickListener onClickListener;
	
	
	@Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage(R.string.delete_dialog_message)
               .setPositiveButton(R.string.delete, onClickListener)
               .setNegativeButton(R.string.cancel, null);
        
        return builder.create();
    }
	
	public void setOnClickListener(final OnClickListener onClickListener){
		this.onClickListener = onClickListener;
	}
	
}
