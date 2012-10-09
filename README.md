Backplane Client README
=======================

This library integrates server side Backplane clients with the Backplane server protocol [https://github.com/janrain/janrain-backplane-2].

Usage
=====

```
ClientCredentials creds = new ClientCredentials("https://backplane1.janrainbackplane.com/", "client id", "secret");
BackplaneClient client = new BackplaneClient(client, true, "bus:foo");

MessageWrapper wrapper = null;
while (true) {
    // connect to Backplane server for 20 seconds at a time
    wrapper = client.getMessages(wrapper, 20);
    ...
}

```



