package senac.com.br.cademeulivro.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "CadeMeuLivro.db";
    private static int DATABASE_VERSION = 1;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //cria tabela Usuario
        db.execSQL("CREATE TABLE Usuario(_id INTEGER PRIMARY KEY, nomeUsuario TEXT);");

        //cria tabela Biblioteca
        db.execSQL("CREATE TABLE Biblioteca(_id INTEGER PRIMARY KEY, usuario_id INTEGER, FOREIGN KEY(usuario_id) REFERENCES Usuario(_id));");

        //cria tabela Container
        db.execSQL("CREATE TABLE Container(_id INTEGER PRIMARY KEY, nomeContainer TEXT, icone INTEGER, local TEXT, ultimaModificacao TEXT, biblioteca_id INTEGER, FOREIGN KEY(biblioteca_id) REFERENCES Biblioteca(_id));");

        //cria tabela Obra
        db.execSQL("CREATE TABLE Obra(_id INTEGER PRIMARY KEY, paginas INTEGER, autor TEXT, titulo TEXT, editora TEXT, emprestado INTEGER, capa BLOB, isbn TEXT, descricao TEXT, edicao INTEGER, anoPublicacao INTEGER, container_id INTEGER, FOREIGN KEY(container_id) REFERENCES Container(_id));");

        //cria tabela Tag
        db.execSQL("CREATE TABLE Tag(_id INTEGER PRIMARY KEY, nomeTag TEXT, corHex TEXT, totalUsos INTEGER);");

        //cria tabela relacionando Tag e Obra
        db.execSQL("CREATE TABLE ObraTag(tag_id INTEGER, obra_id INTEGER, FOREIGN KEY(tag_id) REFERENCES Tag(_id), FOREIGN KEY(obra_id) REFERENCES Obra(_id));");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
