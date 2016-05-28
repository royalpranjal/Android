There are 3 things here...our App, our server & the Braintree server.
First we send a request to out server for client token. The server generates a client token & sends it to the client/app. Then with the 
help of that token & an instance of braintree fragment, we tokenize the card. In return, the Braintree server sends us a nonce (crypto 
string) .That nonce is now send to our server from our app. The server then sends that to the braintree server. This tells that the 
payments/transactions that our app is making is authorized from our server.
