# nsx-t-playground-java

## Upstream samples

https://github.com/vmwaresamples/nsx-t/tree/master/java/

## Installation

https://my.vmware.com/group/vmware/details?downloadGroup=NSX-T-230-SDK-JAVA&productId=673#

## Run me

```bash
$ ssh -L 5001:100.104.252.4:3128 omg.charon-123.appcloud.swisscom.com
$ java com.swisscom.playground.Sample
```

The test script should log into NSX-T using the local proxy over SSH and list some resources.
