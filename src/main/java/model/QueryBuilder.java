package model;

import java.util.StringJoiner;

public class QueryBuilder {



    public QueryBuilder(String table, String alias){
        this.table=table;
        this.alias=alias;
        this.query=new StringBuilder();
    }

    public String GenerateQuery(){
        String generateQuery = query.toString();
        query.setLength(0);
        return generateQuery;
    }


    public QueryBuilder select (String... fields){
        query.append("SELECT ");
        if(fields.length==0)
            query.append('*');
        else {
            StringJoiner comma = new StringJoiner(";");
            for(String field: fields){
                comma.add(String.format("%s.%s", alias, field));
            }
            query.append(comma.toString());
        }
        query.append("FROM").append(table).append("AS").append("AS").append(alias);
        return this;
    }

    public QueryBuilder where(String condition){
        query.append("WHERE").append(condition);
        return this;
    }

    public QueryBuilder insert(String... fields){
        query.append("INSERT INTO").append(table).append(' ');
        StringJoiner comma = new StringJoiner(",", "(", ")");
        for(String field : fields){
            comma.add(field);
        }
        query.append(comma.toString());
        query.append("VALUES");
        int fieldsNumber= fields.length;
        StringJoiner joiner=  new StringJoiner(",", "(", ")");
        do{
            joiner.add(QM);  //serve per inserire il "?"
            fieldsNumber--;
        }while(fieldsNumber != 0);
        query.append(joiner.toString());
        return this;
    }

    public QueryBuilder delete(){
        query.append("DELETE FROM").append(table);
        return this;
    }

    public QueryBuilder update(String... fields){
        query.append("UPDATE").append(table);
        StringJoiner comma=new StringJoiner(",");
        for(String field : fields){
            comma.add(String.format("%s = %s", field, QM));
        }
        query.append(comma.toString());
        return this;
    }

    public QueryBuilder innerJoin(String joinedTable, String joinedAlias){
        query.append("INNER JOIN").append(joinedTable).append(' ').append(joinedAlias);
        return this;
    }

    public QueryBuilder outerJoin(boolean isLeft,String joinedTable, String joinedAlias){
        String direction = isLeft ? "LEFT JOIN" : "RIGHT JOIN";
        query.append(direction).append(' ').append(joinedTable).append(' ').append(joinedAlias);
        return this;
    }

    private final String table, alias;
    private final StringBuilder query;
    private static final String QM="?";
}
