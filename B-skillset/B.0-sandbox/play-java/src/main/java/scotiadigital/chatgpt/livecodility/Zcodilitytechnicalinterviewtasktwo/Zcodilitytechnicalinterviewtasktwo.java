package scotiadigital.chatgpt.livecodility.Zcodilitytechnicalinterviewtasktwo;

/**
 *
 * You are writing an endpoint that returns the total number of items bought in your online store by a given user.
 * Orders in your system are stored in an external service called OrdersService
 * content_copy
 * . Your task is to:
 *
 * write an endpoint in the given UsersController
 * content_copy
 *  class;
 * write a method in the given UsersService
 * content_copy
 *  class that counts the number of items bought by the given user;
 * configure the UsersController
 * content_copy
 *  and UsersService
 * content_copy
 *  classes.
 * Solving this task requires from you editing the following three files. Please make sure they are all present in your final solution.
 *
 * com.codility.app.AppConfiguration
 * content_copy
 * com.codility.app.UsersController
 * content_copy
 * com.codility.app.UsersService
 * content_copy
 * Interfaces
 * The UsersService
 * content_copy
 *  class declares:
 *
 * a field ordersService
 * content_copy
 * : private OrdersService ordersService
 * content_copy
 * a method getNumberOfItemsBought
 * content_copy
 * : public int getNumberOfItemsBought(String username)
 * content_copy
 * The UsersController
 * content_copy
 *  class declares:
 *
 * a field usersService
 * content_copy
 * : private UsersService usersService
 * content_copy
 * a method totalItemsBought
 * content_copy
 * : public Map<String, Integer> totalItemsBought()
 * content_copy
 * They are all present in your initial solution.
 *
 * Environment
 * Your application is written with the Spring Framework.
 *
 * Your Spring context is already populated with the OrdersService
 * content_copy
 *  bean that implements the following interface:
 *
 * package com.codility.external;
 *
 * import java.util.List;
 *
 * public interface OrdersService {
 *
 *     List<Item> itemsBought(String username);
 *
 * }
 *
 * content_copy
 * Note that OrdersService
 * content_copy
 *  is located in the com.codility.external
 * content_copy
 *  package, whereas your application uses the com.codility.app
 * content_copy
 *  package.
 *
 * Requirements
 * Make sure that the AppConfiguration
 * content_copy
 *  class is treated as a Spring configuration bean.
 *
 * Configure Spring to scan for beans in the com.codility.external
 * content_copy
 *  package.
 *
 * Prepare the OrdersService
 * content_copy
 *  bean (please refer to the signatures described above):
 *
 * Inject the OrdersService
 * content_copy
 *  bean into the ordersService
 * content_copy
 *  field.
 * Use it in the getNumberOfItemsBought
 * content_copy
 *  method to count the number of items bought by the given user.
 * Inject UsersService
 * content_copy
 *  into UsersController
 * content_copy
 * .
 *
 * Use it in the totalItemsBought
 * content_copy
 *  method to fetch the number of items bought by the given user.
 *
 * The totalItemsBought
 * content_copy
 *  method should implement the following contract:
 *
 * endpoint URL: /users/{username}/items/total
 * content_copy
 * , where username
 * content_copy
 *  is a path variable;
 * response JSON format: {"totalItemsBought":number}
 * content_copy
 * , where number
 * content_copy
 *  is the number of items bought by the given user;
 * status code 200 in case of a successful response.
 * Make sure you pass the username
 * content_copy
 *  variable to the totalItemsBought
 * content_copy
 *  call.
 *
 * For simplicity, you don't have to write any input validation or error handling.
 *
 * You are working with the Spring Framework version 6.2.7 and Java 21.
 *
 * Copyright 2009–2026 by Codility Limited. All Rights Reserved. Unauthorized copying, publication or disclosure prohibited.
 *
 */
public class Zcodilitytechnicalinterviewtasktwo {
}
