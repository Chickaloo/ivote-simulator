This package implements the criteria for Assignment A1.

The objective was to make a Java-based imitation of iVote.io, using good OOP practices.

I tried to implement a mock webapp-style implementation with a the following pieces:

Server that contains a "database" and handles login/logout of user sessions, as well as a list of "active IVote sessions"

Session that contains a sessionID and a User (not used due to implementation difficulties)

Users that implement Voter, with varying degrees of privileges

Question interface that branches off into multiple different possible question types

IVoteSession that implements a "room" for iVote. Registered users and above may create an IVoteSession that others can join with a token. An IvoteSession has a Question and a Hashtable of responses.

TODO: Fix generic Room Get Content shenanigans
TODO: Add input scrubbing
TODO: Refactor extraneous classes
