package io.realm;


import android.annotation.TargetApi;
import android.os.Build;
import android.util.JsonReader;
import android.util.JsonToken;
import io.realm.RealmObjectSchema;
import io.realm.RealmSchema;
import io.realm.exceptions.RealmMigrationNeededException;
import io.realm.internal.ColumnInfo;
import io.realm.internal.LinkView;
import io.realm.internal.RealmObjectProxy;
import io.realm.internal.Row;
import io.realm.internal.SharedRealm;
import io.realm.internal.Table;
import io.realm.internal.TableOrView;
import io.realm.internal.android.JsonUtils;
import io.realm.log.RealmLog;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GithubUserRealmProxy extends ru.geekbrains.gviewer.model.entity.GithubUser
    implements RealmObjectProxy, GithubUserRealmProxyInterface {

    static final class GithubUserColumnInfo extends ColumnInfo
        implements Cloneable {

        public long loginIndex;
        public long idIndex;
        public long avatarURLIndex;
        public long siteIndex;
        public long nameIndex;
        public long locationIndex;
        public long companyIndex;
        public long emailIndex;
        public long bioIndex;

        GithubUserColumnInfo(String path, Table table) {
            final Map<String, Long> indicesMap = new HashMap<String, Long>(9);
            this.loginIndex = getValidColumnIndex(path, table, "GithubUser", "login");
            indicesMap.put("login", this.loginIndex);
            this.idIndex = getValidColumnIndex(path, table, "GithubUser", "id");
            indicesMap.put("id", this.idIndex);
            this.avatarURLIndex = getValidColumnIndex(path, table, "GithubUser", "avatarURL");
            indicesMap.put("avatarURL", this.avatarURLIndex);
            this.siteIndex = getValidColumnIndex(path, table, "GithubUser", "site");
            indicesMap.put("site", this.siteIndex);
            this.nameIndex = getValidColumnIndex(path, table, "GithubUser", "name");
            indicesMap.put("name", this.nameIndex);
            this.locationIndex = getValidColumnIndex(path, table, "GithubUser", "location");
            indicesMap.put("location", this.locationIndex);
            this.companyIndex = getValidColumnIndex(path, table, "GithubUser", "company");
            indicesMap.put("company", this.companyIndex);
            this.emailIndex = getValidColumnIndex(path, table, "GithubUser", "email");
            indicesMap.put("email", this.emailIndex);
            this.bioIndex = getValidColumnIndex(path, table, "GithubUser", "bio");
            indicesMap.put("bio", this.bioIndex);

            setIndicesMap(indicesMap);
        }

        @Override
        public final void copyColumnInfoFrom(ColumnInfo other) {
            final GithubUserColumnInfo otherInfo = (GithubUserColumnInfo) other;
            this.loginIndex = otherInfo.loginIndex;
            this.idIndex = otherInfo.idIndex;
            this.avatarURLIndex = otherInfo.avatarURLIndex;
            this.siteIndex = otherInfo.siteIndex;
            this.nameIndex = otherInfo.nameIndex;
            this.locationIndex = otherInfo.locationIndex;
            this.companyIndex = otherInfo.companyIndex;
            this.emailIndex = otherInfo.emailIndex;
            this.bioIndex = otherInfo.bioIndex;

            setIndicesMap(otherInfo.getIndicesMap());
        }

        @Override
        public final GithubUserColumnInfo clone() {
            return (GithubUserColumnInfo) super.clone();
        }

    }
    private GithubUserColumnInfo columnInfo;
    private ProxyState proxyState;
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>();
        fieldNames.add("login");
        fieldNames.add("id");
        fieldNames.add("avatarURL");
        fieldNames.add("site");
        fieldNames.add("name");
        fieldNames.add("location");
        fieldNames.add("company");
        fieldNames.add("email");
        fieldNames.add("bio");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    GithubUserRealmProxy() {
        if (proxyState == null) {
            injectObjectContext();
        }
        proxyState.setConstructionFinished();
    }

    private void injectObjectContext() {
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (GithubUserColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState(ru.geekbrains.gviewer.model.entity.GithubUser.class, this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @SuppressWarnings("cast")
    public String realmGet$login() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.loginIndex);
    }

    public void realmSet$login(String value) {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        if (proxyState.isUnderConstruction()) {
            // default value of the primary key is always ignored.
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        throw new io.realm.exceptions.RealmException("Primary key field 'login' cannot be changed after object was created.");
    }

    @SuppressWarnings("cast")
    public String realmGet$id() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.idIndex);
    }

    public void realmSet$id(String value) {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.idIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.idIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.idIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.idIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$avatarURL() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.avatarURLIndex);
    }

    public void realmSet$avatarURL(String value) {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.avatarURLIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.avatarURLIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.avatarURLIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.avatarURLIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$site() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.siteIndex);
    }

    public void realmSet$site(String value) {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.siteIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.siteIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.siteIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.siteIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$name() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.nameIndex);
    }

    public void realmSet$name(String value) {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.nameIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.nameIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.nameIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.nameIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$location() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.locationIndex);
    }

    public void realmSet$location(String value) {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.locationIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.locationIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.locationIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.locationIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$company() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.companyIndex);
    }

    public void realmSet$company(String value) {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.companyIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.companyIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.companyIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.companyIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$email() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.emailIndex);
    }

    public void realmSet$email(String value) {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.emailIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.emailIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.emailIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.emailIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$bio() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.bioIndex);
    }

    public void realmSet$bio(String value) {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.bioIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.bioIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.bioIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.bioIndex, value);
    }

    public static RealmObjectSchema createRealmObjectSchema(RealmSchema realmSchema) {
        if (!realmSchema.contains("GithubUser")) {
            RealmObjectSchema realmObjectSchema = realmSchema.create("GithubUser");
            realmObjectSchema.add(new Property("login", RealmFieldType.STRING, Property.PRIMARY_KEY, Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("id", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("avatarURL", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("site", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("name", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("location", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("company", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("email", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("bio", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            return realmObjectSchema;
        }
        return realmSchema.get("GithubUser");
    }

    public static Table initTable(SharedRealm sharedRealm) {
        if (!sharedRealm.hasTable("class_GithubUser")) {
            Table table = sharedRealm.getTable("class_GithubUser");
            table.addColumn(RealmFieldType.STRING, "login", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "id", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "avatarURL", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "site", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "name", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "location", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "company", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "email", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "bio", Table.NULLABLE);
            table.addSearchIndex(table.getColumnIndex("login"));
            table.setPrimaryKey("login");
            return table;
        }
        return sharedRealm.getTable("class_GithubUser");
    }

    public static GithubUserColumnInfo validateTable(SharedRealm sharedRealm, boolean allowExtraColumns) {
        if (sharedRealm.hasTable("class_GithubUser")) {
            Table table = sharedRealm.getTable("class_GithubUser");
            final long columnCount = table.getColumnCount();
            if (columnCount != 9) {
                if (columnCount < 9) {
                    throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is less than expected - expected 9 but was " + columnCount);
                }
                if (allowExtraColumns) {
                    RealmLog.debug("Field count is more than expected - expected 9 but was %1$d", columnCount);
                } else {
                    throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is more than expected - expected 9 but was " + columnCount);
                }
            }
            Map<String, RealmFieldType> columnTypes = new HashMap<String, RealmFieldType>();
            for (long i = 0; i < 9; i++) {
                columnTypes.put(table.getColumnName(i), table.getColumnType(i));
            }

            final GithubUserColumnInfo columnInfo = new GithubUserColumnInfo(sharedRealm.getPath(), table);

            if (!columnTypes.containsKey("login")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'login' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("login") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'login' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.loginIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(),"@PrimaryKey field 'login' does not support null values in the existing Realm file. Migrate using RealmObjectSchema.setNullable(), or mark the field as @Required.");
            }
            if (table.getPrimaryKey() != table.getColumnIndex("login")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Primary key not defined for field 'login' in existing Realm file. Add @PrimaryKey.");
            }
            if (!table.hasSearchIndex(table.getColumnIndex("login"))) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Index not defined for field 'login' in existing Realm file. Either set @Index or migrate using io.realm.internal.Table.removeSearchIndex().");
            }
            if (!columnTypes.containsKey("id")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'id' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("id") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'id' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.idIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'id' is required. Either set @Required to field 'id' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("avatarURL")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'avatarURL' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("avatarURL") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'avatarURL' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.avatarURLIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'avatarURL' is required. Either set @Required to field 'avatarURL' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("site")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'site' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("site") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'site' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.siteIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'site' is required. Either set @Required to field 'site' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("name")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'name' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("name") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'name' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.nameIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'name' is required. Either set @Required to field 'name' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("location")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'location' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("location") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'location' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.locationIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'location' is required. Either set @Required to field 'location' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("company")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'company' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("company") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'company' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.companyIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'company' is required. Either set @Required to field 'company' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("email")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'email' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("email") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'email' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.emailIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'email' is required. Either set @Required to field 'email' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("bio")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'bio' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("bio") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'bio' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.bioIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'bio' is required. Either set @Required to field 'bio' or migrate using RealmObjectSchema.setNullable().");
            }
            return columnInfo;
        } else {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "The 'GithubUser' class is missing from the schema for this Realm.");
        }
    }

    public static String getTableName() {
        return "class_GithubUser";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static ru.geekbrains.gviewer.model.entity.GithubUser createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        ru.geekbrains.gviewer.model.entity.GithubUser obj = null;
        if (update) {
            Table table = realm.getTable(ru.geekbrains.gviewer.model.entity.GithubUser.class);
            long pkColumnIndex = table.getPrimaryKey();
            long rowIndex = TableOrView.NO_MATCH;
            if (json.isNull("login")) {
                rowIndex = table.findFirstNull(pkColumnIndex);
            } else {
                rowIndex = table.findFirstString(pkColumnIndex, json.getString("login"));
            }
            if (rowIndex != TableOrView.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(ru.geekbrains.gviewer.model.entity.GithubUser.class), false, Collections.<String> emptyList());
                    obj = new io.realm.GithubUserRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("login")) {
                if (json.isNull("login")) {
                    obj = (io.realm.GithubUserRealmProxy) realm.createObjectInternal(ru.geekbrains.gviewer.model.entity.GithubUser.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.GithubUserRealmProxy) realm.createObjectInternal(ru.geekbrains.gviewer.model.entity.GithubUser.class, json.getString("login"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'login'.");
            }
        }
        if (json.has("id")) {
            if (json.isNull("id")) {
                ((GithubUserRealmProxyInterface) obj).realmSet$id(null);
            } else {
                ((GithubUserRealmProxyInterface) obj).realmSet$id((String) json.getString("id"));
            }
        }
        if (json.has("avatarURL")) {
            if (json.isNull("avatarURL")) {
                ((GithubUserRealmProxyInterface) obj).realmSet$avatarURL(null);
            } else {
                ((GithubUserRealmProxyInterface) obj).realmSet$avatarURL((String) json.getString("avatarURL"));
            }
        }
        if (json.has("site")) {
            if (json.isNull("site")) {
                ((GithubUserRealmProxyInterface) obj).realmSet$site(null);
            } else {
                ((GithubUserRealmProxyInterface) obj).realmSet$site((String) json.getString("site"));
            }
        }
        if (json.has("name")) {
            if (json.isNull("name")) {
                ((GithubUserRealmProxyInterface) obj).realmSet$name(null);
            } else {
                ((GithubUserRealmProxyInterface) obj).realmSet$name((String) json.getString("name"));
            }
        }
        if (json.has("location")) {
            if (json.isNull("location")) {
                ((GithubUserRealmProxyInterface) obj).realmSet$location(null);
            } else {
                ((GithubUserRealmProxyInterface) obj).realmSet$location((String) json.getString("location"));
            }
        }
        if (json.has("company")) {
            if (json.isNull("company")) {
                ((GithubUserRealmProxyInterface) obj).realmSet$company(null);
            } else {
                ((GithubUserRealmProxyInterface) obj).realmSet$company((String) json.getString("company"));
            }
        }
        if (json.has("email")) {
            if (json.isNull("email")) {
                ((GithubUserRealmProxyInterface) obj).realmSet$email(null);
            } else {
                ((GithubUserRealmProxyInterface) obj).realmSet$email((String) json.getString("email"));
            }
        }
        if (json.has("bio")) {
            if (json.isNull("bio")) {
                ((GithubUserRealmProxyInterface) obj).realmSet$bio(null);
            } else {
                ((GithubUserRealmProxyInterface) obj).realmSet$bio((String) json.getString("bio"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static ru.geekbrains.gviewer.model.entity.GithubUser createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        ru.geekbrains.gviewer.model.entity.GithubUser obj = new ru.geekbrains.gviewer.model.entity.GithubUser();
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (name.equals("login")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((GithubUserRealmProxyInterface) obj).realmSet$login(null);
                } else {
                    ((GithubUserRealmProxyInterface) obj).realmSet$login((String) reader.nextString());
                }
                jsonHasPrimaryKey = true;
            } else if (name.equals("id")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((GithubUserRealmProxyInterface) obj).realmSet$id(null);
                } else {
                    ((GithubUserRealmProxyInterface) obj).realmSet$id((String) reader.nextString());
                }
            } else if (name.equals("avatarURL")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((GithubUserRealmProxyInterface) obj).realmSet$avatarURL(null);
                } else {
                    ((GithubUserRealmProxyInterface) obj).realmSet$avatarURL((String) reader.nextString());
                }
            } else if (name.equals("site")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((GithubUserRealmProxyInterface) obj).realmSet$site(null);
                } else {
                    ((GithubUserRealmProxyInterface) obj).realmSet$site((String) reader.nextString());
                }
            } else if (name.equals("name")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((GithubUserRealmProxyInterface) obj).realmSet$name(null);
                } else {
                    ((GithubUserRealmProxyInterface) obj).realmSet$name((String) reader.nextString());
                }
            } else if (name.equals("location")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((GithubUserRealmProxyInterface) obj).realmSet$location(null);
                } else {
                    ((GithubUserRealmProxyInterface) obj).realmSet$location((String) reader.nextString());
                }
            } else if (name.equals("company")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((GithubUserRealmProxyInterface) obj).realmSet$company(null);
                } else {
                    ((GithubUserRealmProxyInterface) obj).realmSet$company((String) reader.nextString());
                }
            } else if (name.equals("email")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((GithubUserRealmProxyInterface) obj).realmSet$email(null);
                } else {
                    ((GithubUserRealmProxyInterface) obj).realmSet$email((String) reader.nextString());
                }
            } else if (name.equals("bio")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((GithubUserRealmProxyInterface) obj).realmSet$bio(null);
                } else {
                    ((GithubUserRealmProxyInterface) obj).realmSet$bio((String) reader.nextString());
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        if (!jsonHasPrimaryKey) {
            throw new IllegalArgumentException("JSON object doesn't have the primary key field 'login'.");
        }
        obj = realm.copyToRealm(obj);
        return obj;
    }

    public static ru.geekbrains.gviewer.model.entity.GithubUser copyOrUpdate(Realm realm, ru.geekbrains.gviewer.model.entity.GithubUser object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().threadId != realm.threadId) {
            throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
        }
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return object;
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (ru.geekbrains.gviewer.model.entity.GithubUser) cachedRealmObject;
        } else {
            ru.geekbrains.gviewer.model.entity.GithubUser realmObject = null;
            boolean canUpdate = update;
            if (canUpdate) {
                Table table = realm.getTable(ru.geekbrains.gviewer.model.entity.GithubUser.class);
                long pkColumnIndex = table.getPrimaryKey();
                String value = ((GithubUserRealmProxyInterface) object).realmGet$login();
                long rowIndex = TableOrView.NO_MATCH;
                if (value == null) {
                    rowIndex = table.findFirstNull(pkColumnIndex);
                } else {
                    rowIndex = table.findFirstString(pkColumnIndex, value);
                }
                if (rowIndex != TableOrView.NO_MATCH) {
                    try {
                        objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(ru.geekbrains.gviewer.model.entity.GithubUser.class), false, Collections.<String> emptyList());
                        realmObject = new io.realm.GithubUserRealmProxy();
                        cache.put(object, (RealmObjectProxy) realmObject);
                    } finally {
                        objectContext.clear();
                    }
                } else {
                    canUpdate = false;
                }
            }

            if (canUpdate) {
                return update(realm, realmObject, object, cache);
            } else {
                return copy(realm, object, update, cache);
            }
        }
    }

    public static ru.geekbrains.gviewer.model.entity.GithubUser copy(Realm realm, ru.geekbrains.gviewer.model.entity.GithubUser newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (ru.geekbrains.gviewer.model.entity.GithubUser) cachedRealmObject;
        } else {
            // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
            ru.geekbrains.gviewer.model.entity.GithubUser realmObject = realm.createObjectInternal(ru.geekbrains.gviewer.model.entity.GithubUser.class, ((GithubUserRealmProxyInterface) newObject).realmGet$login(), false, Collections.<String>emptyList());
            cache.put(newObject, (RealmObjectProxy) realmObject);
            ((GithubUserRealmProxyInterface) realmObject).realmSet$id(((GithubUserRealmProxyInterface) newObject).realmGet$id());
            ((GithubUserRealmProxyInterface) realmObject).realmSet$avatarURL(((GithubUserRealmProxyInterface) newObject).realmGet$avatarURL());
            ((GithubUserRealmProxyInterface) realmObject).realmSet$site(((GithubUserRealmProxyInterface) newObject).realmGet$site());
            ((GithubUserRealmProxyInterface) realmObject).realmSet$name(((GithubUserRealmProxyInterface) newObject).realmGet$name());
            ((GithubUserRealmProxyInterface) realmObject).realmSet$location(((GithubUserRealmProxyInterface) newObject).realmGet$location());
            ((GithubUserRealmProxyInterface) realmObject).realmSet$company(((GithubUserRealmProxyInterface) newObject).realmGet$company());
            ((GithubUserRealmProxyInterface) realmObject).realmSet$email(((GithubUserRealmProxyInterface) newObject).realmGet$email());
            ((GithubUserRealmProxyInterface) realmObject).realmSet$bio(((GithubUserRealmProxyInterface) newObject).realmGet$bio());
            return realmObject;
        }
    }

    public static long insert(Realm realm, ru.geekbrains.gviewer.model.entity.GithubUser object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(ru.geekbrains.gviewer.model.entity.GithubUser.class);
        long tableNativePtr = table.getNativeTablePointer();
        GithubUserColumnInfo columnInfo = (GithubUserColumnInfo) realm.schema.getColumnInfo(ru.geekbrains.gviewer.model.entity.GithubUser.class);
        long pkColumnIndex = table.getPrimaryKey();
        String primaryKeyValue = ((GithubUserRealmProxyInterface) object).realmGet$login();
        long rowIndex = TableOrView.NO_MATCH;
        if (primaryKeyValue == null) {
            rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
        } else {
            rowIndex = Table.nativeFindFirstString(tableNativePtr, pkColumnIndex, primaryKeyValue);
        }
        if (rowIndex == TableOrView.NO_MATCH) {
            rowIndex = table.addEmptyRowWithPrimaryKey(primaryKeyValue, false);
        } else {
            Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
        }
        cache.put(object, rowIndex);
        String realmGet$id = ((GithubUserRealmProxyInterface)object).realmGet$id();
        if (realmGet$id != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.idIndex, rowIndex, realmGet$id, false);
        }
        String realmGet$avatarURL = ((GithubUserRealmProxyInterface)object).realmGet$avatarURL();
        if (realmGet$avatarURL != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.avatarURLIndex, rowIndex, realmGet$avatarURL, false);
        }
        String realmGet$site = ((GithubUserRealmProxyInterface)object).realmGet$site();
        if (realmGet$site != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.siteIndex, rowIndex, realmGet$site, false);
        }
        String realmGet$name = ((GithubUserRealmProxyInterface)object).realmGet$name();
        if (realmGet$name != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
        }
        String realmGet$location = ((GithubUserRealmProxyInterface)object).realmGet$location();
        if (realmGet$location != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.locationIndex, rowIndex, realmGet$location, false);
        }
        String realmGet$company = ((GithubUserRealmProxyInterface)object).realmGet$company();
        if (realmGet$company != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.companyIndex, rowIndex, realmGet$company, false);
        }
        String realmGet$email = ((GithubUserRealmProxyInterface)object).realmGet$email();
        if (realmGet$email != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.emailIndex, rowIndex, realmGet$email, false);
        }
        String realmGet$bio = ((GithubUserRealmProxyInterface)object).realmGet$bio();
        if (realmGet$bio != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.bioIndex, rowIndex, realmGet$bio, false);
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(ru.geekbrains.gviewer.model.entity.GithubUser.class);
        long tableNativePtr = table.getNativeTablePointer();
        GithubUserColumnInfo columnInfo = (GithubUserColumnInfo) realm.schema.getColumnInfo(ru.geekbrains.gviewer.model.entity.GithubUser.class);
        long pkColumnIndex = table.getPrimaryKey();
        ru.geekbrains.gviewer.model.entity.GithubUser object = null;
        while (objects.hasNext()) {
            object = (ru.geekbrains.gviewer.model.entity.GithubUser) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                String primaryKeyValue = ((GithubUserRealmProxyInterface) object).realmGet$login();
                long rowIndex = TableOrView.NO_MATCH;
                if (primaryKeyValue == null) {
                    rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
                } else {
                    rowIndex = Table.nativeFindFirstString(tableNativePtr, pkColumnIndex, primaryKeyValue);
                }
                if (rowIndex == TableOrView.NO_MATCH) {
                    rowIndex = table.addEmptyRowWithPrimaryKey(primaryKeyValue, false);
                } else {
                    Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
                }
                cache.put(object, rowIndex);
                String realmGet$id = ((GithubUserRealmProxyInterface)object).realmGet$id();
                if (realmGet$id != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.idIndex, rowIndex, realmGet$id, false);
                }
                String realmGet$avatarURL = ((GithubUserRealmProxyInterface)object).realmGet$avatarURL();
                if (realmGet$avatarURL != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.avatarURLIndex, rowIndex, realmGet$avatarURL, false);
                }
                String realmGet$site = ((GithubUserRealmProxyInterface)object).realmGet$site();
                if (realmGet$site != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.siteIndex, rowIndex, realmGet$site, false);
                }
                String realmGet$name = ((GithubUserRealmProxyInterface)object).realmGet$name();
                if (realmGet$name != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
                }
                String realmGet$location = ((GithubUserRealmProxyInterface)object).realmGet$location();
                if (realmGet$location != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.locationIndex, rowIndex, realmGet$location, false);
                }
                String realmGet$company = ((GithubUserRealmProxyInterface)object).realmGet$company();
                if (realmGet$company != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.companyIndex, rowIndex, realmGet$company, false);
                }
                String realmGet$email = ((GithubUserRealmProxyInterface)object).realmGet$email();
                if (realmGet$email != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.emailIndex, rowIndex, realmGet$email, false);
                }
                String realmGet$bio = ((GithubUserRealmProxyInterface)object).realmGet$bio();
                if (realmGet$bio != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.bioIndex, rowIndex, realmGet$bio, false);
                }
            }
        }
    }

    public static long insertOrUpdate(Realm realm, ru.geekbrains.gviewer.model.entity.GithubUser object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(ru.geekbrains.gviewer.model.entity.GithubUser.class);
        long tableNativePtr = table.getNativeTablePointer();
        GithubUserColumnInfo columnInfo = (GithubUserColumnInfo) realm.schema.getColumnInfo(ru.geekbrains.gviewer.model.entity.GithubUser.class);
        long pkColumnIndex = table.getPrimaryKey();
        String primaryKeyValue = ((GithubUserRealmProxyInterface) object).realmGet$login();
        long rowIndex = TableOrView.NO_MATCH;
        if (primaryKeyValue == null) {
            rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
        } else {
            rowIndex = Table.nativeFindFirstString(tableNativePtr, pkColumnIndex, primaryKeyValue);
        }
        if (rowIndex == TableOrView.NO_MATCH) {
            rowIndex = table.addEmptyRowWithPrimaryKey(primaryKeyValue, false);
        }
        cache.put(object, rowIndex);
        String realmGet$id = ((GithubUserRealmProxyInterface)object).realmGet$id();
        if (realmGet$id != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.idIndex, rowIndex, realmGet$id, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.idIndex, rowIndex, false);
        }
        String realmGet$avatarURL = ((GithubUserRealmProxyInterface)object).realmGet$avatarURL();
        if (realmGet$avatarURL != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.avatarURLIndex, rowIndex, realmGet$avatarURL, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.avatarURLIndex, rowIndex, false);
        }
        String realmGet$site = ((GithubUserRealmProxyInterface)object).realmGet$site();
        if (realmGet$site != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.siteIndex, rowIndex, realmGet$site, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.siteIndex, rowIndex, false);
        }
        String realmGet$name = ((GithubUserRealmProxyInterface)object).realmGet$name();
        if (realmGet$name != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.nameIndex, rowIndex, false);
        }
        String realmGet$location = ((GithubUserRealmProxyInterface)object).realmGet$location();
        if (realmGet$location != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.locationIndex, rowIndex, realmGet$location, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.locationIndex, rowIndex, false);
        }
        String realmGet$company = ((GithubUserRealmProxyInterface)object).realmGet$company();
        if (realmGet$company != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.companyIndex, rowIndex, realmGet$company, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.companyIndex, rowIndex, false);
        }
        String realmGet$email = ((GithubUserRealmProxyInterface)object).realmGet$email();
        if (realmGet$email != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.emailIndex, rowIndex, realmGet$email, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.emailIndex, rowIndex, false);
        }
        String realmGet$bio = ((GithubUserRealmProxyInterface)object).realmGet$bio();
        if (realmGet$bio != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.bioIndex, rowIndex, realmGet$bio, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.bioIndex, rowIndex, false);
        }
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(ru.geekbrains.gviewer.model.entity.GithubUser.class);
        long tableNativePtr = table.getNativeTablePointer();
        GithubUserColumnInfo columnInfo = (GithubUserColumnInfo) realm.schema.getColumnInfo(ru.geekbrains.gviewer.model.entity.GithubUser.class);
        long pkColumnIndex = table.getPrimaryKey();
        ru.geekbrains.gviewer.model.entity.GithubUser object = null;
        while (objects.hasNext()) {
            object = (ru.geekbrains.gviewer.model.entity.GithubUser) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                String primaryKeyValue = ((GithubUserRealmProxyInterface) object).realmGet$login();
                long rowIndex = TableOrView.NO_MATCH;
                if (primaryKeyValue == null) {
                    rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
                } else {
                    rowIndex = Table.nativeFindFirstString(tableNativePtr, pkColumnIndex, primaryKeyValue);
                }
                if (rowIndex == TableOrView.NO_MATCH) {
                    rowIndex = table.addEmptyRowWithPrimaryKey(primaryKeyValue, false);
                }
                cache.put(object, rowIndex);
                String realmGet$id = ((GithubUserRealmProxyInterface)object).realmGet$id();
                if (realmGet$id != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.idIndex, rowIndex, realmGet$id, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.idIndex, rowIndex, false);
                }
                String realmGet$avatarURL = ((GithubUserRealmProxyInterface)object).realmGet$avatarURL();
                if (realmGet$avatarURL != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.avatarURLIndex, rowIndex, realmGet$avatarURL, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.avatarURLIndex, rowIndex, false);
                }
                String realmGet$site = ((GithubUserRealmProxyInterface)object).realmGet$site();
                if (realmGet$site != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.siteIndex, rowIndex, realmGet$site, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.siteIndex, rowIndex, false);
                }
                String realmGet$name = ((GithubUserRealmProxyInterface)object).realmGet$name();
                if (realmGet$name != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.nameIndex, rowIndex, false);
                }
                String realmGet$location = ((GithubUserRealmProxyInterface)object).realmGet$location();
                if (realmGet$location != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.locationIndex, rowIndex, realmGet$location, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.locationIndex, rowIndex, false);
                }
                String realmGet$company = ((GithubUserRealmProxyInterface)object).realmGet$company();
                if (realmGet$company != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.companyIndex, rowIndex, realmGet$company, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.companyIndex, rowIndex, false);
                }
                String realmGet$email = ((GithubUserRealmProxyInterface)object).realmGet$email();
                if (realmGet$email != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.emailIndex, rowIndex, realmGet$email, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.emailIndex, rowIndex, false);
                }
                String realmGet$bio = ((GithubUserRealmProxyInterface)object).realmGet$bio();
                if (realmGet$bio != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.bioIndex, rowIndex, realmGet$bio, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.bioIndex, rowIndex, false);
                }
            }
        }
    }

    public static ru.geekbrains.gviewer.model.entity.GithubUser createDetachedCopy(ru.geekbrains.gviewer.model.entity.GithubUser realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        ru.geekbrains.gviewer.model.entity.GithubUser unmanagedObject;
        if (cachedObject != null) {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (ru.geekbrains.gviewer.model.entity.GithubUser)cachedObject.object;
            } else {
                unmanagedObject = (ru.geekbrains.gviewer.model.entity.GithubUser)cachedObject.object;
                cachedObject.minDepth = currentDepth;
            }
        } else {
            unmanagedObject = new ru.geekbrains.gviewer.model.entity.GithubUser();
            cache.put(realmObject, new RealmObjectProxy.CacheData(currentDepth, unmanagedObject));
        }
        ((GithubUserRealmProxyInterface) unmanagedObject).realmSet$login(((GithubUserRealmProxyInterface) realmObject).realmGet$login());
        ((GithubUserRealmProxyInterface) unmanagedObject).realmSet$id(((GithubUserRealmProxyInterface) realmObject).realmGet$id());
        ((GithubUserRealmProxyInterface) unmanagedObject).realmSet$avatarURL(((GithubUserRealmProxyInterface) realmObject).realmGet$avatarURL());
        ((GithubUserRealmProxyInterface) unmanagedObject).realmSet$site(((GithubUserRealmProxyInterface) realmObject).realmGet$site());
        ((GithubUserRealmProxyInterface) unmanagedObject).realmSet$name(((GithubUserRealmProxyInterface) realmObject).realmGet$name());
        ((GithubUserRealmProxyInterface) unmanagedObject).realmSet$location(((GithubUserRealmProxyInterface) realmObject).realmGet$location());
        ((GithubUserRealmProxyInterface) unmanagedObject).realmSet$company(((GithubUserRealmProxyInterface) realmObject).realmGet$company());
        ((GithubUserRealmProxyInterface) unmanagedObject).realmSet$email(((GithubUserRealmProxyInterface) realmObject).realmGet$email());
        ((GithubUserRealmProxyInterface) unmanagedObject).realmSet$bio(((GithubUserRealmProxyInterface) realmObject).realmGet$bio());
        return unmanagedObject;
    }

    static ru.geekbrains.gviewer.model.entity.GithubUser update(Realm realm, ru.geekbrains.gviewer.model.entity.GithubUser realmObject, ru.geekbrains.gviewer.model.entity.GithubUser newObject, Map<RealmModel, RealmObjectProxy> cache) {
        ((GithubUserRealmProxyInterface) realmObject).realmSet$id(((GithubUserRealmProxyInterface) newObject).realmGet$id());
        ((GithubUserRealmProxyInterface) realmObject).realmSet$avatarURL(((GithubUserRealmProxyInterface) newObject).realmGet$avatarURL());
        ((GithubUserRealmProxyInterface) realmObject).realmSet$site(((GithubUserRealmProxyInterface) newObject).realmGet$site());
        ((GithubUserRealmProxyInterface) realmObject).realmSet$name(((GithubUserRealmProxyInterface) newObject).realmGet$name());
        ((GithubUserRealmProxyInterface) realmObject).realmSet$location(((GithubUserRealmProxyInterface) newObject).realmGet$location());
        ((GithubUserRealmProxyInterface) realmObject).realmSet$company(((GithubUserRealmProxyInterface) newObject).realmGet$company());
        ((GithubUserRealmProxyInterface) realmObject).realmSet$email(((GithubUserRealmProxyInterface) newObject).realmGet$email());
        ((GithubUserRealmProxyInterface) realmObject).realmSet$bio(((GithubUserRealmProxyInterface) newObject).realmGet$bio());
        return realmObject;
    }

    @Override
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("GithubUser = [");
        stringBuilder.append("{login:");
        stringBuilder.append(realmGet$login() != null ? realmGet$login() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{id:");
        stringBuilder.append(realmGet$id() != null ? realmGet$id() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{avatarURL:");
        stringBuilder.append(realmGet$avatarURL() != null ? realmGet$avatarURL() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{site:");
        stringBuilder.append(realmGet$site() != null ? realmGet$site() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{name:");
        stringBuilder.append(realmGet$name() != null ? realmGet$name() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{location:");
        stringBuilder.append(realmGet$location() != null ? realmGet$location() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{company:");
        stringBuilder.append(realmGet$company() != null ? realmGet$company() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{email:");
        stringBuilder.append(realmGet$email() != null ? realmGet$email() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{bio:");
        stringBuilder.append(realmGet$bio() != null ? realmGet$bio() : "null");
        stringBuilder.append("}");
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public ProxyState realmGet$proxyState() {
        return proxyState;
    }

    @Override
    public int hashCode() {
        String realmName = proxyState.getRealm$realm().getPath();
        String tableName = proxyState.getRow$realm().getTable().getName();
        long rowIndex = proxyState.getRow$realm().getIndex();

        int result = 17;
        result = 31 * result + ((realmName != null) ? realmName.hashCode() : 0);
        result = 31 * result + ((tableName != null) ? tableName.hashCode() : 0);
        result = 31 * result + (int) (rowIndex ^ (rowIndex >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GithubUserRealmProxy aGithubUser = (GithubUserRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aGithubUser.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aGithubUser.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aGithubUser.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }

}
