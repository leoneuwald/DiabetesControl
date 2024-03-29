package com.diabetescontrol.adapters;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.diabetescontrol.model.Paciente;

public class PacienteAdapter extends BaseAdapter {

	private Context ctx;
	private List<Paciente> lista;

	public PacienteAdapter(Context ctx, List<Paciente> lista) {
		this.ctx = ctx;
		this.lista = lista;
	}

	@Override
	public int getCount() {
		return lista.size();
	}

	@Override
	public Object getItem(int position) {
		return lista.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		Paciente paciente = lista.get(position);
		LayoutInflater layout = (LayoutInflater) ctx
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View v = layout.inflate(
				com.diabetescontrol.activities.R.layout.lista_paciente, null);
		ImageView btEdit = (ImageView) v
				.findViewById(com.diabetescontrol.activities.R.id.btEdit);
		if (position > 0) {
			btEdit.setVisibility(View.GONE);
			TextView tituloEdit = (TextView) v
					.findViewById(com.diabetescontrol.activities.R.id.textView1);
			tituloEdit.setVisibility(View.GONE);
		}

		TextView txtID = (TextView) v
				.findViewById(com.diabetescontrol.activities.R.id.tvCod);
		txtID.setText(paciente.getId().toString());
		txtID.setVisibility(View.GONE);

		TextView txtNome = (TextView) v
				.findViewById(com.diabetescontrol.activities.R.id.tvPrinc);
		txtNome.setText(paciente.getNome());

		TextView txtEmail = (TextView) v
				.findViewById(com.diabetescontrol.activities.R.id.tvSec);
		txtEmail.setText(paciente.getEmail());

		return v;
	}

}
