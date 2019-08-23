<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>SQLCMDWEB</title>
        Welcome to SQLCMDWEB <br>
    </head>
    <body>
            Plese find list of available commands here::<br>
                    1. clear. This command can be used to clear the content of the table.:<br>
                          format: clear [your_table_name], for example (clear table1):<br>
                    2. close. This commeand is used to close connection to the database and switch to unconnected mode.:<br>
                    3. create. This command is used to create new table on the database you are connected to.:<br>
                          Format: create [your_table_name] [column1|column1_type] [column2|column2_type]...:<br>
                          for example (create table1 column1|text column2|int):<br>
                          Available column types: "BOOL", "CHAR\", "VARCHAR", "TEXT", "SMALLINT", "INT"
                                "SERIAL", "float", "DATE", "TIME", "TIMESTAMP", "INTERVAL"
                                "UUID", "Array", "JSON", "hstore":<br>
                    4. delete. This command is used to delete row on a table, where columnValue = Value:<br>
                          Format: delete [table_name] [column|value]:<br>
                          For example (delete table1 column1|'any_text'):<br>
                          In this case, any row that contains value that equels 'any_text' at column1 will be deleted:<br>
                    5. drop. This command is used to drop the table" ):<br>
                          Format drop [table_name]. For example (drop table1) table with name table1 will be drepped.:<br>
                    6. find This command is used to print out content of the table.:<br>
                          Format: find [table_name]. For example (find table1) will print out content of the table1:<br>
                    7. pwd. This command is used to print the name of connected database:<br>
                    8. help. This command is used to get help))))))):<br>
                    9. insert. This command is used to inser new row on a table.:<br>
                          Format: insert [table_name] [column1|value] [column2|value]...:<br>
                          For example (insert table1 column1|'any_text' column2|12) will insert new row into table table1 " +
                               with corresponding values column1 = 'any_text' and column2 = 12:<br>
                    10. list. This command is used to drint all available tables.:<br>
                    11. update. This command is used to update value1 on a column1 where value on a column0 = value0:<br>
                          Format update table_name column0|value0 colunm1|value1:<br>
                          For example (update table1 column1|'roadHouse' column2|123) in this case row with value " +
                               'roadHouse' on a column1 will be found and column2 value of this row will be changed to 123:<br>
                    12. make. To create new database:<br>
                          Format: make [database_name]:<br>

        <%@include file="footer.jsp" %>
    </body>
</html>