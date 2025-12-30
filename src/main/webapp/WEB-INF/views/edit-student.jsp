<%--
  Created by IntelliJ IDEA.
  User: VENKATARAJU
  Date: 30-12-2025
  Time: 09:03
  To change this template use File | Settings | File Templates.
--%>
<form action="updateStudent" method="post">

    <input type="hidden" name="id" value="${student.id}" />

    Name: <input type="text" name="name" value="${student.name}" /><br/><br/>
    Email: <input type="text" name="email" value="${student.email}" /><br/><br/>
    Course: <input type="text" name="course" value="${student.course}" /><br/><br/>

    <input type="submit" value="Update Student" />

</form>

