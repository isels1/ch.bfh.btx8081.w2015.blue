USE [HealthVisAppDB]
GO

INSERT INTO [dbo].[state]
           ([id])
     VALUES
           (1)
GO

INSERT INTO [dbo].[state]
           ([id])
     VALUES
           (2 )
GO

INSERT INTO [dbo].[state]
           ([id])
     VALUES
           (3)
GO

INSERT INTO [dbo].[state]
           ([id])
     VALUES
           (4)
GO

INSERT INTO [dbo].[stateNew]
           ([id]
           ,[name]
           ,[description]
           ,[colourCode])
     VALUES
           (1
           ,'New'
           ,'Patient State New'
           ,'patientStateNew')
GO

INSERT INTO [dbo].[stateAmbulant]
           ([id]
           ,[name]
           ,[description]
           ,[colourCode])
     VALUES
           (2
           ,'Ambulant'
           ,'Patient State Ambulant'
           ,'patientStateAmbulant')
GO

INSERT INTO [dbo].[stateStationary]
           ([id]
           ,[name]
           ,[description]
           ,[colourCode])
     VALUES
           (3
           ,'Stationary'
           ,'Patient State Stationary'
           ,'patientStateStationary')
GO

INSERT INTO [dbo].[stateArchived]
           ([id]
           ,[name]
           ,[description]
           ,[colourCode])
     VALUES
           (4
           ,'Archived'
           ,'Patient State Archived'
           ,'patientStateArchived')
GO